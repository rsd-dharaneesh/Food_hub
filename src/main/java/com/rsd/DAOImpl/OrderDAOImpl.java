package com.rsd.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rsd.DAO.OrderDAO;
import com.rsd.model.Orders;
import com.rsd.utility.DBConnection;

public class OrderDAOImpl implements OrderDAO {
	
	private static final String INSERT_QUERY =
			"INSERT INTO orders(user_id,restaurant_id,order_date,total_amount,status,payment_method) VALUES(?,?,?,?,?,?)";
	

	@Override
	public int addOrder(Orders order) {

	    Connection connection = DBConnection.getConnection();

	    try {

	    	PreparedStatement pstmt = connection.prepareStatement(
	    	        INSERT_QUERY,
	    	        Statement.RETURN_GENERATED_KEYS
	    	);

	        pstmt.setInt(1, order.getUserId());
	        pstmt.setInt(2, order.getRestaurantId());
	        pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
	        pstmt.setDouble(4, order.getTotalAmount());
	        pstmt.setString(5, order.getStatus());
	        pstmt.setString(6, order.getPaymentMethod());

	        int rows = pstmt.executeUpdate();

	        if(rows > 0){

	            ResultSet rs = pstmt.getGeneratedKeys();

	            if(rs.next()){

	                int orderId = rs.getInt(1);

	                System.out.println("Order Added Successfully. Order ID : " + orderId);

	                return orderId;
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	
	

	@Override
	public Orders getOrder(int orderId) {

	    String GET_QUERY = "SELECT * FROM orders WHERE order_id = ?";

	    Connection connection = DBConnection.getConnection();

	    Orders order = null;

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(GET_QUERY);

	        pstmt.setInt(1, orderId);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            order = extractOrderFromResultSet(rs);

	        }

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }

	    return order;
	}
	
	

	@Override
	public List<Orders> getAllOrders() {

	    Connection connection = DBConnection.getConnection();

	    ArrayList<Orders> list = new ArrayList<>();

	    String GET_ALL_QUERY = "SELECT * FROM orders";

	    try {

	        Statement stmt = connection.createStatement();

	        ResultSet rs = stmt.executeQuery(GET_ALL_QUERY);

	        while (rs.next()) {

	            Orders order = extractOrderFromResultSet(rs);

	            list.add(order);
	        }

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }

	    return list;
	}
	
	

	
	
	@Override
	public void updateOrder(Orders order) {

	    String UPDATE_QUERY =
	            "UPDATE orders SET user_id=?, restaurant_id=?, total_amount=?, status=?, payment_method=? WHERE order_id=?";

	    Connection connection = DBConnection.getConnection();

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);

	        pstmt.setInt(1, order.getUserId());
	        pstmt.setInt(2, order.getRestaurantId());
	        pstmt.setDouble(3, order.getTotalAmount());
	        pstmt.setString(4, order.getStatus());
	        pstmt.setString(5, order.getPaymentMethod());
	        pstmt.setInt(6, order.getOrderId());

	        int i = pstmt.executeUpdate();

	        System.out.println(i + " Order Updated Successfully");

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }
	}
	
	
	

	@Override
	public void deleteOrder(int orderId) {

	    String DELETE_QUERY = "DELETE FROM orders WHERE order_id=?";

	    Connection connection = DBConnection.getConnection();

	    try {

	        PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);

	        pstmt.setInt(1, orderId);

	        int i = pstmt.executeUpdate();

	        System.out.println(i + " Order Deleted Successfully");

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }
	}
	
	
	public static Orders extractOrderFromResultSet(ResultSet rs) throws SQLException {

	    Orders order = new Orders();

	    order.setOrderId(rs.getInt("order_id"));
	    order.setUserId(rs.getInt("user_id"));
	    order.setRestaurantId(rs.getInt("restaurant_id"));
	    order.setOrderDate(rs.getTimestamp("order_date"));
	    order.setTotalAmount(rs.getDouble("total_amount"));
	    order.setStatus(rs.getString("status"));
	    order.setPaymentMethod(rs.getString("payment_method"));

	    return order;
	}



	@Override
	public List<Orders> getOrdersByUserId(int userId) {

	    List<Orders> orders = new ArrayList<>();

	    String query =
	            "SELECT * FROM orders WHERE user_id=? ORDER BY order_date DESC";

	    Connection connection = DBConnection.getConnection();

	    try {

	        PreparedStatement pstmt =
	                connection.prepareStatement(query);

	        pstmt.setInt(1, userId);

	        ResultSet rs = pstmt.executeQuery();

	        while(rs.next()) {

	            orders.add(extractOrderFromResultSet(rs));

	        }

	    } catch (SQLException e) {

	        e.printStackTrace();

	    }

	    return orders;
	}

}