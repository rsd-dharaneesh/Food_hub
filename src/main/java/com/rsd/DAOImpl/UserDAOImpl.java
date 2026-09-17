package com.rsd.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rsd.DAO.UserDAO;
import com.rsd.model.User;
import com.rsd.utility.DBConnection;

public class UserDAOImpl implements UserDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO user(username,email,password,address,phone,role,created_date,lastdatelogin) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void addUser(User user) {

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getRole());
            pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

            int i = pstmt.executeUpdate();

            System.out.println(i + " User Added Successfully");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public User getUser(int user_id) {

        String GET_QUERY = "SELECT * FROM user WHERE user_id=?";

        Connection connection = DBConnection.getConnection();

        User user = null;

        try {

            PreparedStatement pstmt = connection.prepareStatement(GET_QUERY);

            pstmt.setInt(1, user_id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                user = extractUserFromResultSet(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean updateUser(User user) {

        String query = "UPDATE user SET username=?, email=?, address=?, phone=? WHERE user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getPhone());
            pstmt.setInt(5, user.getUser_id());

            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void deleteUser(int user_id) {

        String DELETE_QUERY = "DELETE FROM user WHERE user_id=?";

        Connection connection = DBConnection.getConnection();

        try {

            PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, user_id);

            int i = pstmt.executeUpdate();

            System.out.println(i + " User Deleted Successfully");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAlluser() {

        Connection connection = DBConnection.getConnection();

        ArrayList<User> list = new ArrayList<>();

        String GET_ALL_QUERY = "SELECT * FROM user";

        try {

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(GET_ALL_QUERY);

            while (rs.next()) {

                User user = extractUserFromResultSet(rs);

                list.add(user);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }

    public static User extractUserFromResultSet(ResultSet rs) throws SQLException {

        int id = rs.getInt("user_id");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        String role = rs.getString("role");
        Timestamp createdDate = rs.getTimestamp("created_date");
        Timestamp lastLogin = rs.getTimestamp("lastdatelogin");

        return new User(
                id,
                username,
                email,
                password,
                address,
                phone,
                role,
                createdDate,
                lastLogin
        );
    }
    
    

    @Override
    public User getUserByEmail(String email) {

        String GET_BY_EMAIL = "SELECT * FROM user WHERE email=?";

        Connection connection = DBConnection.getConnection();

        User user = null;

        try {

            PreparedStatement pstmt = connection.prepareStatement(GET_BY_EMAIL);

            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                user = extractUserFromResultSet(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return user;
    }
    																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
}