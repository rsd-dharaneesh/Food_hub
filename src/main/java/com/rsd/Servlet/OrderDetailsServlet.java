package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.rsd.DAOImpl.MenuDAOImpl;
import com.rsd.DAOImpl.OrderDAOImpl;
import com.rsd.DAOImpl.OrderItemDAOImpl;
import com.rsd.model.Menu;
import com.rsd.model.OrderItem;
import com.rsd.model.Orders;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));

        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();

        Orders order = orderDAO.getOrder(orderId);

        List<OrderItem> orderItems =
                orderItemDAO.getOrderItemsByOrderId(orderId);

        request.setAttribute("order", order);
        request.setAttribute("orderItems", orderItems);
        request.setAttribute("menuDAO", menuDAO);

        request.getRequestDispatcher("orderDetails.jsp")
               .forward(request, response);
    }
}