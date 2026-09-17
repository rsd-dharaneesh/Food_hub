package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.rsd.DAOImpl.OrderDAOImpl;
import com.rsd.model.Orders;
import com.rsd.model.User;

@WebServlet("/myOrders")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user =
                (User) session.getAttribute("loggedInUser");

        if(user == null){

            response.sendRedirect("login.jsp");
            return;

        }

        OrderDAOImpl dao = new OrderDAOImpl();

        List<Orders> orders =
                dao.getOrdersByUserId(user.getUser_id());

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("orderHistory.jsp")
               .forward(request, response);

    }

}