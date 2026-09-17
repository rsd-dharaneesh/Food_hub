package com.rsd.model;

import java.sql.Timestamp;

public class User {

    private int user_id;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String role;
    private Timestamp created_date;
    private Timestamp lastdatelogin;

    public User() {

    }

    public User(int user_id, String username, String email, String password,
            String address, String phone, String role,
            Timestamp created_date, Timestamp lastdatelogin) {

        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.created_date = created_date;
        this.lastdatelogin = lastdatelogin;
    }

    public User(String username, String email, String password,
            String address, String phone, String role,
            Timestamp created_date, Timestamp lastdatelogin) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.created_date = created_date;
        this.lastdatelogin = lastdatelogin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getLastdatelogin() {
        return lastdatelogin;
    }

    public void setLastdatelogin(Timestamp lastdatelogin) {
        this.lastdatelogin = lastdatelogin;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id +
                ", username=" + username +
                ", email=" + email +
                ", password=" + password +
                ", address=" + address +
                ", phone=" + phone +
                ", role=" + role +
                ", created_date=" + created_date +
                ", lastdatelogin=" + lastdatelogin + "]";
    }

}