package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rsd.model.CartItem;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        double subtotal = 0;

        for (CartItem item : cart) {
            subtotal += item.getTotalPrice();
        }

        double deliveryCharge = 40;
        double gst = 20;
        double grandTotal = subtotal + deliveryCharge + gst;

        request.setAttribute("cart", cart);
        request.setAttribute("subtotal", subtotal);
        request.setAttribute("delivery", deliveryCharge);
        request.setAttribute("gst", gst);
        request.setAttribute("grandTotal", grandTotal);

        request.getRequestDispatcher("checkout.jsp")
               .forward(request, response);
    }
}