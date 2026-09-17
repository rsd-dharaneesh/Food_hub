package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.rsd.model.CartItem;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int menuId = Integer.parseInt(request.getParameter("menuId"));
        String action = request.getParameter("action");

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {

            for (int i = 0; i < cart.size(); i++) {

                CartItem item = cart.get(i);

                if (item.getMenu().getMenuId() == menuId) {

                    switch (action) {

                        case "increase":
                            item.setQuantity(item.getQuantity() + 1);
                            break;

                        case "decrease":
                            if (item.getQuantity() > 1) {
                                item.setQuantity(item.getQuantity() - 1);
                            } else {
                                cart.remove(i);
                            }
                            break;

                        case "remove":
                            cart.remove(i);
                            break;
                    }

                    break;
                }
            }

            session.setAttribute("cart", cart);
        }

        response.sendRedirect("cart.jsp");
    }
}