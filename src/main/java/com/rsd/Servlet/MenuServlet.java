package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.DAOImpl.MenuDAOImpl;
import com.rsd.DAOImpl.RestaurantDAOImpl;
import com.rsd.model.Menu;
import com.rsd.model.Restaurant;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String restaurantIdParam = request.getParameter("restaurantId");

        if (restaurantIdParam == null || restaurantIdParam.trim().isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        int restaurantId;

        try {
            restaurantId = Integer.parseInt(restaurantIdParam);
        } catch (NumberFormatException e) {
            response.sendRedirect("index.jsp");
            return;
        }

        MenuDAOImpl menuDAO = new MenuDAOImpl();
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();

        Restaurant restaurant = restaurantDAO.getRestaurant(restaurantId);

        List<Menu> menus = menuDAO.getMenusByRestaurantId(restaurantId);

        request.setAttribute("restaurant", restaurant);
        request.setAttribute("menus", menus);

        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}