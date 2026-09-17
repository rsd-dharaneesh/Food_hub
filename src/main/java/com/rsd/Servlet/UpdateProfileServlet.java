package com.rsd.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rsd.DAO.UserDAO;
import com.rsd.DAOImpl.UserDAOImpl;
import com.rsd.model.User;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Read form data
        int userId = Integer.parseInt(request.getParameter("userId"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        UserDAO userDAO = new UserDAOImpl();

        // Get existing user
        User user = userDAO.getUser(userId);

        if (user != null) {

            user.setUsername(username);
            user.setEmail(email);
            user.setPhone(phone);
            user.setAddress(address);

            boolean updated = userDAO.updateUser(user);

            if (updated) {

                // Update session
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", user);

                response.sendRedirect("profile");

            } else {

                response.sendRedirect("editProfile");

            }

        } else {

            response.sendRedirect("login.jsp");

        }

    }
}