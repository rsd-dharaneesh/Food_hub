package com.rsd.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rsd.DAO.OrderItemDAO;
import com.rsd.model.OrderItem;
import com.rsd.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {
	
	private static final String INSERT_QUERY =
			"INSERT INTO orderitem(order_id,menu_id,quantity,item_total) VALUES(?,?,?,?)";
	

	
	@Override
	public void addOrderItem(OrderItem orderItem) {

	    Connection connection = DBConnection.getConnection();

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);

	        pstmt.setInt(1, orderItem.getOrderId());
	        pstmt.setInt(2, orderItem.getMenuId());
	        pstmt.setInt(3, orderItem.getQuantity());
	        pstmt.setDouble(4, orderItem.getItemTotal());

	        int i = pstmt.executeUpdate();

	        System.out.println(i + " Order Item Added Successfully");

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }
	}
	
	

	
    @Override
    public OrderItem getOrderItem(int orderItemId) {

        String GET_QUERY = "SELECT * FROM orderitem WHERE order_item_id=?";

        Connection connection = DBConnection.getConnection();

        OrderItem orderItem = null;

        try {

            PreparedStatement pstmt = connection.prepareStatement(GET_QUERY);

            pstmt.setInt(1, orderItemId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                orderItem = extractOrderItemFromResultSet(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return orderItem;
    }
    
    

	
    @Override
    public List<OrderItem> getAllOrderItems() {

        Connection connection = DBConnection.getConnection();

        ArrayList<OrderItem> list = new ArrayList<>();

        String GET_ALL_QUERY = "SELECT * FROM orderitem";

        try {

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(GET_ALL_QUERY);

            while (rs.next()) {

                OrderItem orderItem = extractOrderItemFromResultSet(rs);

                list.add(orderItem);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }
    
    
    

    @Override
    public void updateOrderItem(OrderItem orderItem) {

        String UPDATE_QUERY =
                "UPDATE orderitem SET order_id=?, menu_id=?, quantity=?, item_total=? WHERE order_item_id=?";

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());
            pstmt.setInt(5, orderItem.getOrderItemId());

            int i = pstmt.executeUpdate();

            System.out.println(i + " Order Item Updated Successfully");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    
    

    @Override
    public void deleteOrderItem(int orderItemId) {

        String DELETE_QUERY = "DELETE FROM orderitem WHERE order_item_id=?";

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, orderItemId);

            int i = pstmt.executeUpdate();

            System.out.println(i + " Order Item Deleted Successfully");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    
    
	
	
    public static OrderItem extractOrderItemFromResultSet(ResultSet rs) throws SQLException {

        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItemId(rs.getInt("order_item_id"));
        orderItem.setOrderId(rs.getInt("order_id"));
        orderItem.setMenuId(rs.getInt("menu_id"));
        orderItem.setQuantity(rs.getInt("quantity"));
        orderItem.setItemTotal(rs.getDouble("item_total"));

        return orderItem;
    }




    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> orderItems = new ArrayList<>();

        String query = "SELECT * FROM orderitem WHERE order_id=?";

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                orderItems.add(extractOrderItemFromResultSet(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return orderItems;
    }

}

