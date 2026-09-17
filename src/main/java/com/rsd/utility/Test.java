package com.rsd.utility;

import com.rsd.DAO.OrderItemDAO;
import com.rsd.DAOImpl.OrderItemDAOImpl;
import com.rsd.model.OrderItem;

public class Test 
{

    public static void main(String[] args) 
    {

        //UserDAO dao = new UserDAOImpl();

        //User user = new User();

        //user.setUsername("Dharaneesh");
        //user.setEmail("dharaneesh@gmail.com");
        //user.setPassword("3130");
        //user.setAddress("Chennai");
        //user.setRole("Customer");

        //dao.addUser(user);
        
//Get User 
        
        //User user1 = dao.getUser(1);
        //System.out.println(user1);
        
        //Update User
        
        //User user01 = dao.getUser(1);
        //user01.setUsername("Ramcharan");
        //user01.setPassword("ram@2005");
        //dao.updateUser(user01);
    	
//Adding restaurant
    	
        //RestaurantDAO dao1 = new RestaurantDAOImpl();

    	//Restaurant restaurant = new Restaurant();

    	//restaurant.setName("A2B");
    	//restaurant.setCuisineType("South Indian");
    	//restaurant.setDeliveryTime(30);
    	//restaurant.setAddress("Chennai");
    	//restaurant.setAdminUserId(1);
    	//restaurant.setRating(4.5);
    	//restaurant.setActive(true);
    	

        //dao1.addRestaurant(restaurant);
    	
        
//checking restaurant is added are not 
    	
        //RestaurantDAO dao01 = new RestaurantDAOImpl();

        //Restaurant restaurant1 = dao01.getRestaurant(1);

        //System.out.println(restaurant1);
        
    
//Updating restaurant
    	
    	       // RestaurantDAO dao = new RestaurantDAOImpl();

    	       // Restaurant restaurant = dao.getRestaurant(1);

    	       // restaurant.setName("SS Hyderabad Biryani");
    	       // restaurant.setCuisineType("Biryani");
    	       //restaurant.setDeliveryTime(45);
    	       // restaurant.setAddress("Coimbatore");
    	       // restaurant.setRating(4.8);

    	        //dao.updateRestaurant(restaurant);

    	       // System.out.println(dao.getRestaurant(1));
    	
//Deleting restaurant
    	
    	//RestaurantDAO dao = new RestaurantDAOImpl();

    	//dao.deleteRestaurant(2);

    	//System.out.println(dao.getAllRestaurants());
    	
//Add menu
    	//MenuDAO dao = new MenuDAOImpl();

        //Menu menu = new Menu();

        //menu.setRestaurantId(1);
        //menu.setItemName("Chicken Biryani");
        //menu.setDescription("Hyderabadi Dum Biryani");
        //menu.setPrice(250);
        //menu.setAvailable(true);
        //menu.setCategory("Main Course");

        //dao.addMenu(menu);
    	
//Get menu
    	//MenuDAO dao = new MenuDAOImpl();

    	//System.out.println(dao.getMenu(1));
    	
    	
 //Get Allmenu
    	
    	//MenuDAO dao = new MenuDAOImpl();

    	//for (Menu m : dao.getAllMenus()) {

    	    //System.out.println(m);

    	//}
    	
//Update menu
    	//MenuDAO dao = new MenuDAOImpl();

    	//Menu menu = dao.getMenu(1);

    	//menu.setPrice(280);
    	//menu.setItemName("Chicken Dum Biryani");

    	//dao.updateMenu(menu);

    	//System.out.println(dao.getMenu(1));
    
//Delete menu
    	
    	//MenuDAO dao = new MenuDAOImpl();

    	//dao.deleteMenu(1);

    	//System.out.println(dao.getAllMenus());
    	
//Add orders
    	
    	 //OrderDAO dao = new OrderDAOImpl();
         //Orders order = new Orders();
         //order.setUserId(1);
         //order.setRestaurantId(1);
         //order.setTotalAmount(290);
         //order.setStatus("Pending");
         //order.setPaymentMethod("UPI");

         //dao.addOrder(order);
//Get order
    	
    	//OrderDAO dao = new OrderDAOImpl();

    	//System.out.println(dao.getOrder(1));
    	
//Get AllOrder
    	
    	//OrderDAO dao = new OrderDAOImpl();
    	//for (Orders order : dao.getAllOrders()) {
    	    //System.out.println(order);
    	//}
    	
//Update order
    	
    	//OrderDAO dao = new OrderDAOImpl();
    	//Orders order = dao.getOrder(1);
    	//order.setStatus("Delivered");
    	//order.setPaymentMethod("Cash");
    	//dao.updateOrder(order);
    	//System.out.println(dao.getOrder(1));
    	
//Delete Order
    	
    	//OrderDAO dao = new OrderDAOImpl();
    	//dao.deleteOrder(1);
    	//System.out.println(dao.getAllOrders());
    	
//Add orderItem
    	//OrderItemDAO dao = new OrderItemDAOImpl();
    	//OrderItem item = new OrderItem();
    	//item.setOrderId(2);
    	//item.setMenuId(2);   // Use the actual menu_id
    	//item.setQuantity(2);
    	//item.setItemTotal(500);
    	//dao.addOrderItem(item);
    	
//Get OrderItem
    	
    	//OrderItemDAO dao = new OrderItemDAOImpl();
    	//OrderItem item = new OrderItem();
    	//System.out.println(dao.getOrderItem(1));
    	
//GetAll
    	//OrderItemDAO dao = new OrderItemDAOImpl();
    	//OrderItem item = new OrderItem();
    	//for(OrderItem item1 : dao.getAllOrderItems()) {
    	//    System.out.println(item1);
    	//}
    	
    	
//Update OrderItem
    	//OrderItemDAO dao = new OrderItemDAOImpl();
    	//OrderItem item = dao.getOrderItem(5);
    	//if (item != null) {
    	    //item.setQuantity(3);
    	    //item.setItemTotal(750);

    	    //dao.updateOrderItem(item);

    	    //System.out.println(dao.getOrderItem(5));
    	// } else {
    	//   System.out.println("OrderItem not found.");
    	//}
    	
    	
//delete OrderItem
    	
    	OrderItemDAO dao = new OrderItemDAOImpl();
    	OrderItem item = new OrderItem();
    	dao.deleteOrderItem(1);
    	
    }
    	
}
