package com.rsd.DAO;

import java.util.List;
import com.rsd.model.OrderItem;

public interface OrderItemDAO {

    void addOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(int orderItemId);

    List<OrderItem> getAllOrderItems();

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(int orderItemId);
    
    List<OrderItem> getOrderItemsByOrderId(int orderId);
}