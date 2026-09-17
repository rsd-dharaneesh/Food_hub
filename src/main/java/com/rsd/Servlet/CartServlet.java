package com.rsd.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.rsd.DAOImpl.MenuDAOImpl;
import com.rsd.model.CartItem;
import com.rsd.model.Menu;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        @SuppressWarnings("unchecked")
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("cart.jsp")
               .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int menuId = Integer.parseInt(request.getParameter("menuId"));
        
        System.out.println("===== CartServlet Called =====");
        System.out.println("Menu ID = " + request.getParameter("menuId"));
        
        MenuDAOImpl menuDAO = new MenuDAOImpl();

        Menu menu = menuDAO.getMenu(menuId);

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;

        for (CartItem item : cart) {

            if (item.getMenu().getMenuId() == menuId) {

                item.setQuantity(item.getQuantity() + 1);

                found = true;

                break;
            }
        }

        if (!found) {

            cart.add(new CartItem(menu, 1));

        }
       
        session.setAttribute("cart", cart);
        
     // Check if the request came from JavaScript (AJAX)
        String requestedWith = request.getHeader("X-Requested-With");

        if ("XMLHttpRequest".equals(requestedWith)) {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            double cartTotal = 0;

            for (CartItem item : cart) {
                cartTotal += item.getMenu().getPrice() * item.getQuantity();
            }

            int cartCount = 0;

            for (CartItem item : cart) {
                cartCount += item.getQuantity();
            }

            response.getWriter().write(
                "{"
                + "\"status\":\"success\","
                + "\"cartCount\":" + cartCount + ","
                + "\"cartTotal\":" + cartTotal
                + "}"
            );

        } else {

            // Normal browser request
            response.sendRedirect(request.getHeader("Referer"));

        }
        }
}