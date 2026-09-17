package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rsd.DAOImpl.OrderDAOImpl;
import com.rsd.DAOImpl.OrderItemDAOImpl;
import com.rsd.DAOImpl.UserDAOImpl;
import com.rsd.model.CartItem;
import com.rsd.model.OrderItem;
import com.rsd.model.Orders;
import com.rsd.model.User;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	
    	

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {

            response.sendRedirect("login.jsp");
            return;

        }

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {

            response.sendRedirect("cart");
            return;

        }

        // ===========================
        // GET FORM DATA
        // ===========================

        String paymentMethod =
                request.getParameter("paymentMethod");

        String deliveryAddress =
                request.getParameter("deliveryAddress");

        // ===========================
        // UPDATE USER ADDRESS
        // ===========================

        if (deliveryAddress != null &&
                !deliveryAddress.trim().isEmpty()) {

            user.setAddress(deliveryAddress);

            UserDAOImpl userDAO = new UserDAOImpl();

            userDAO.updateUser(user);

            session.setAttribute("loggedInUser", user);

        }

        // ===========================
        // CALCULATE TOTAL
        // ===========================

        double subtotal = 0;

        for (CartItem item : cart) {

            subtotal += item.getTotalPrice();

        }

        double deliveryCharge =
                subtotal >= 499 ? 0 : 40;

        double gst =
                subtotal * 0.05;

        double grandTotal =
                subtotal + deliveryCharge + gst;

        // ===========================
        // RESTAURANT ID
        // ===========================

        int restaurantId =
                cart.get(0).getMenu().getRestaurantId();

        // ===========================
        // CREATE ORDER
        // ===========================

        Orders order = new Orders(

                user.getUser_id(),

                restaurantId,

                grandTotal,

                "Pending",

                paymentMethod

        );

        OrderDAOImpl orderDAO =
                new OrderDAOImpl();

        int orderId =
                orderDAO.addOrder(order);

        if (orderId == -1) {

            response.sendRedirect("checkout");
            return;

        }

        // ===========================
        // SAVE ORDER ITEMS
        // ===========================

        OrderItemDAOImpl orderItemDAO =
                new OrderItemDAOImpl();

        for (CartItem item : cart) {

            OrderItem orderItem =
                    new OrderItem();

            orderItem.setOrderId(orderId);

            orderItem.setMenuId(
                    item.getMenu().getMenuId());

            orderItem.setQuantity(
                    item.getQuantity());

            orderItem.setItemTotal(
                    item.getTotalPrice());

            orderItemDAO.addOrderItem(orderItem);

        }

        // ===========================
        // CLEAR CART
        // ===========================

        session.removeAttribute("cart");

        response.sendRedirect(
                "orderSuccess.jsp?orderId=" + orderId);

    }

}