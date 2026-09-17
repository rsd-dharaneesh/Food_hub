package com.rsd.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.rsd.model.User;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("loggedInUser") == null){

            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedInUser");

        request.setAttribute("user", user);

        request.getRequestDispatcher("editProfile.jsp")
               .forward(request, response);
    }

}