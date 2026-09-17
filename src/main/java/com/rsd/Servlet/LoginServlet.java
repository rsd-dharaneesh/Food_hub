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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAOImpl();

        User user = userDAO.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("loggedInUser", user);

            response.sendRedirect("RestaurantServlet");

        } else {

            response.sendRedirect("login.jsp?error=invalid");

        }

    }

}