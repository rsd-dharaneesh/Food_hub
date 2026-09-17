package com.rsd.DAO;

import java.util.List;

import com.rsd.model.User;

public interface UserDAO {

    void addUser(User user);

    User getUser(int user_id);

    boolean updateUser(User user);

    void deleteUser(int user_id);

    List<User> getAlluser();
    
    User getUserByEmail(String email);
    
}