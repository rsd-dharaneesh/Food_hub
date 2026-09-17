package com.rsd.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rsd.DAO.RestaurantDAO;
import com.rsd.model.Restaurant;
import com.rsd.utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO restaurant(name,cuisine_type,delivery_time,address,admin_user_id,rating,is_active,image_path) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void addRestaurant(Restaurant restaurant) {

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);

            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setInt(3, restaurant.getDeliveryTime());
            pstmt.setString(4, restaurant.getAddress());
            pstmt.setInt(5, restaurant.getAdminUserId());
            pstmt.setDouble(6, restaurant.getRating());
            pstmt.setBoolean(7, restaurant.isActive());
            pstmt.setString(8, restaurant.getImagePath());

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " Restaurant Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
    
    @Override
    public Restaurant getRestaurant(int restaurantId) {

        String GET_QUERY = "SELECT * FROM restaurant WHERE restaurant_id = ?";

        Connection connection = DBConnection.getConnection();

        Restaurant restaurant = null;

        try {

            PreparedStatement pstmt = connection.prepareStatement(GET_QUERY);

            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                restaurant = extractRestaurantFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }
    

	
    @Override
    public List<Restaurant> getAllRestaurants() {

        Connection connection = DBConnection.getConnection();

        ArrayList<Restaurant> list = new ArrayList<>();

        String GET_ALL_QUERY = "SELECT * FROM restaurant";

        try {

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(GET_ALL_QUERY);

            while (rs.next()) {

                Restaurant restaurant = extractRestaurantFromResultSet(rs);

                list.add(restaurant);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }
    
    

    @Override
    public void updateRestaurant(Restaurant restaurant) {

        String UPDATE_QUERY =
                "UPDATE restaurant SET name=?, cuisine_type=?, delivery_time=?, address=?, admin_user_id=?, rating=?, is_active=?, image_path=? WHERE restaurant_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY)) {

            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setInt(3, restaurant.getDeliveryTime());
            pstmt.setString(4, restaurant.getAddress());
            pstmt.setInt(5, restaurant.getAdminUserId());
            pstmt.setDouble(6, restaurant.getRating());
            pstmt.setBoolean(7, restaurant.isActive());
            pstmt.setString(8, restaurant.getImagePath());
            pstmt.setInt(9, restaurant.getRestaurantId());

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " Restaurant Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

    @Override
    public void deleteRestaurant(int restaurantId) {

        String DELETE_QUERY = "DELETE FROM restaurant WHERE restaurant_id=?";

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, restaurantId);

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " Restaurant Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

	public static Restaurant extractRestaurantFromResultSet(ResultSet rs) throws SQLException {

	    Restaurant restaurant = new Restaurant();

	    restaurant.setRestaurantId(rs.getInt("restaurant_id"));
	    restaurant.setName(rs.getString("name"));
	    restaurant.setCuisineType(rs.getString("cuisine_type"));
	    restaurant.setDeliveryTime(rs.getInt("delivery_time"));
	    restaurant.setAddress(rs.getString("address"));
	    restaurant.setAdminUserId(rs.getInt("admin_user_id"));
	    restaurant.setRating(rs.getDouble("rating"));
	    restaurant.setActive(rs.getBoolean("is_active"));
	    restaurant.setImagePath(rs.getString("image_path"));

	    return restaurant;
	}
}