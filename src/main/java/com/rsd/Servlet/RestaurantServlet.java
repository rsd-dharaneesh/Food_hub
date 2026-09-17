package com.rsd.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsd.DAOImpl.RestaurantDAOImpl;
import com.rsd.model.Restaurant;

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();

        List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurants();

        System.out.println("Restaurant List = " + allRestaurants);
        System.out.println("Restaurant Count = " + allRestaurants.size());

        req.setAttribute("allRestaurants", allRestaurants);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
