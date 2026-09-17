package com.rsd.Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.DAO.UserDAO;
import com.rsd.DAOImpl.UserDAOImpl;
import com.rsd.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Read form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        UserDAO userDAO = new UserDAOImpl();

        // Check if email already exists
        User existingUser = userDAO.getUserByEmail(email);

        if (existingUser != null) {

            response.getWriter().println(
                    "<h2>Email already registered!</h2>"
                    + "<a href='register.jsp'>Try Again</a>");

            return;
        }

        // Create new user
        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole("CUSTOMER");

        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setCreated_date(now);
        user.setLastdatelogin(now);

        // Save user
        userDAO.addUser(user);

        // Redirect to login page
        response.sendRedirect("login.jsp?success=registered");
    }
}