package com.rsd.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rsd.DAO.MenuDAO;
import com.rsd.model.Menu;
import com.rsd.utility.DBConnection;

public class MenuDAOImpl implements MenuDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO menu (restaurant_id, item_name, description, price, is_available, category, created_at, updated_at, deleted_at, image_url, rating, food_type, bestseller) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void addMenu(Menu menu) {

        Timestamp now = new Timestamp(System.currentTimeMillis());

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY)) {

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setString(6, menu.getCategory());

            pstmt.setTimestamp(7, now);
            pstmt.setTimestamp(8, now);
            pstmt.setTimestamp(9, null);

            pstmt.setString(10, menu.getImageUrl());
            pstmt.setDouble(11, menu.getRating());
            pstmt.setString(12, menu.getFoodType());
            pstmt.setBoolean(13, menu.isBestseller());

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " Menu Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuId) {

        String sql = "SELECT * FROM menu WHERE menu_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, menuId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return extractMenuFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Menu> getAllMenus() {

        List<Menu> menus = new ArrayList<>();

        String sql = "SELECT * FROM menu";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                menus.add(extractMenuFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    @Override
    public void updateMenu(Menu menu) {

        String sql =
                "UPDATE menu SET restaurant_id=?, item_name=?, description=?, price=?, is_available=?, category=?, image_url=?, rating=?, food_type=?, bestseller=?, updated_at=? WHERE menu_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.isAvailable());
            pstmt.setString(6, menu.getCategory());

            pstmt.setString(7, menu.getImageUrl());
            pstmt.setDouble(8, menu.getRating());
            pstmt.setString(9, menu.getFoodType());
            pstmt.setBoolean(10, menu.isBestseller());

            pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));

            pstmt.setInt(12, menu.getMenuId());

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " Menu Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {

        String sql = "DELETE FROM menu WHERE menu_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, menuId);

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " Menu Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getMenusByRestaurantId(int restaurantId) {

        List<Menu> menus = new ArrayList<>();

        String sql = "SELECT * FROM menu WHERE restaurant_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                menus.add(extractMenuFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    private Menu extractMenuFromResultSet(ResultSet rs) throws SQLException {

        Menu menu = new Menu();

        menu.setMenuId(rs.getInt("menu_id"));
        menu.setRestaurantId(rs.getInt("restaurant_id"));
        menu.setItemName(rs.getString("item_name"));
        menu.setDescription(rs.getString("description"));
        menu.setPrice(rs.getDouble("price"));
        menu.setAvailable(rs.getBoolean("is_available"));
        menu.setCategory(rs.getString("category"));

        menu.setCreatedAt(rs.getTimestamp("created_at"));
        menu.setUpdatedAt(rs.getTimestamp("updated_at"));
        menu.setDeletedAt(rs.getTimestamp("deleted_at"));

        menu.setImageUrl(rs.getString("image_url"));
        menu.setRating(rs.getDouble("rating"));
        menu.setFoodType(rs.getString("food_type"));
        menu.setBestseller(rs.getBoolean("bestseller"));

        return menu;
    }
}