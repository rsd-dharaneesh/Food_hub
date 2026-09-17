package com.rsd.model;

import java.sql.Timestamp;

public class Menu {

    private int menuId;
    private int restaurantId;
    private String itemName;
    private String description;
    private double price;
    private boolean isAvailable;
    private String category;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    // New Fields
    private String imageUrl;
    private double rating;
    private String foodType;
    private boolean bestseller;

    // Default Constructor
    public Menu() {
    }

    // Full Constructor
    public Menu(int menuId, int restaurantId, String itemName,
            String description, double price, boolean isAvailable,
            String category, Timestamp createdAt,
            Timestamp updatedAt, Timestamp deletedAt,
            String imageUrl, double rating,
            String foodType, boolean bestseller) {

        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.foodType = foodType;
        this.bestseller = bestseller;
    }

    // Constructor for Adding Menu
    public Menu(int restaurantId, String itemName,
            String description, double price,
            boolean isAvailable, String category,
            String imageUrl, double rating,
            String foodType, boolean bestseller) {

        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.foodType = foodType;
        this.bestseller = bestseller;
    }

    // Getters and Setters

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", restaurantId=" + restaurantId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rating=" + rating +
                ", foodType='" + foodType + '\'' +
                ", bestseller=" + bestseller +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}