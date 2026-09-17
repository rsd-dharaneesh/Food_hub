package com.rsd.DAO;

import java.util.List;

import com.rsd.model.Orders;

public interface OrderDAO {

    int addOrder(Orders order);

    Orders getOrder(int orderId);

    List<Orders> getAllOrders();

    void updateOrder(Orders order);

    void deleteOrder(int orderId);
    
    List<Orders> getOrdersByUserId(int userId);
}