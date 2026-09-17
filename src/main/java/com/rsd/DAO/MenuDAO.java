package com.rsd.DAO;

import java.util.List;

import com.rsd.model.Menu;

public interface MenuDAO {

    void addMenu(Menu menu);

    Menu getMenu(int menuId);

    List<Menu> getAllMenus();
    List<Menu> getMenusByRestaurantId(int restaurantId);

    void updateMenu(Menu menu);

    void deleteMenu(int menuId);

}