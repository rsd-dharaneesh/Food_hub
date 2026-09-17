# FoodHub -- Food Delivery Web Application

FoodHub is a Java Full Stack food delivery web application developed as
a learning and portfolio project during my Java Full Stack Development
journey at TAP Academy.

The application demonstrates a complete food-ordering workflow: user
registration and login, restaurant browsing, menu selection, cart
management, checkout, order placement, order history, and profile
management.

## Features

-   User registration and login
-   Session-based authentication
-   Restaurant listing with cuisine, delivery time, rating, address, and
    images
-   Restaurant menu browsing
-   Add food items to cart
-   Cart quantity and total-price handling
-   Checkout with editable delivery address
-   Subtotal, delivery fee, GST, and grand-total calculation
-   Payment-method selection:
    -   Cash On Delivery
    -   UPI
    -   Credit Card
    -   Debit Card
-   Order placement and order confirmation
-   Order history and order details
-   User profile viewing and editing
-   MySQL database persistence
-   Responsive checkout UI

> The payment options are currently selections stored with the order; a
> real payment gateway is not integrated.

> The checkout includes a coupon UI, but coupon validation/discount
> processing is not implemented in the current version.

## Technology Stack

  Layer                   Technology
  ----------------------- -------------------------
  Frontend                HTML5, CSS3, JavaScript
  View                    JSP
  Backend                 Java Servlets
  Database Connectivity   JDBC
  Database                MySQL
  Server                  Apache Tomcat
  IDE                     Eclipse
  Database Tool           MySQL Workbench
  Version Control         Git / GitHub
  Git Client              GitHub Desktop

## Application Flow

``` text
Register
   ↓
Login
   ↓
Restaurant List
   ↓
Select Restaurant
   ↓
View Menu
   ↓
Add Food to Cart
   ↓
View Cart
   ↓
Checkout
   ↓
Enter / Update Delivery Address
   ↓
Select Payment Method
   ↓
Place Order
   ↓
Create Order
   ↓
Create Order Items
   ↓
Clear Cart
   ↓
Order Success
   ↓
Order History / Order Details
```

## Main Modules

### 1. User Module

Users can register, log in, view their profile, and update profile
information.

The application stores user information such as:

-   Username
-   Email
-   Password
-   Address
-   Phone
-   Role
-   Created date
-   Last login

### 2. Restaurant Module

Users can browse available restaurants and view restaurant information
including:

-   Restaurant name
-   Cuisine type
-   Delivery time
-   Address
-   Rating
-   Image

### 3. Menu Module

Users can select a restaurant and view its available food items.

Menu information includes food name, food type, price, image, and
restaurant association.

### 4. Cart Module

Users can add menu items to their cart and manage quantities.

Cart information is maintained using the HTTP session.

Example:

``` java
session.setAttribute("cart", cart);
```

### 5. Checkout Module

The checkout page contains:

-   Customer details
-   Delivery address
-   Order summary
-   Subtotal
-   Delivery fee
-   GST
-   Grand total
-   Payment method
-   Coupon UI
-   Delivery information

### 6. Order Module

When an order is placed, the application:

1.  Reads the logged-in user from the session.
2.  Reads the cart.
3.  Reads the delivery address and payment method.
4.  Updates the user's address when required.
5.  Calculates the order total.
6.  Creates an order in the `orders` table.
7.  Creates corresponding records in `orderitem`.
8.  Clears the cart.
9.  Redirects the user to the order-success page.

## Billing Logic

The current application uses:

``` text
Subtotal = Sum of cart item totals

Delivery Fee:
    Subtotal >= ₹499 → Free
    Subtotal < ₹499  → ₹40

GST = Subtotal × 5%

Grand Total = Subtotal + Delivery Fee + GST
```

The total is calculated again in the server-side order-processing flow
before the order is stored.

## Database

The project uses MySQL.

Main tables:

### `user`

Stores registered user information.

### `restaurant`

Stores restaurant information.

### `menu`

Stores food/menu items associated with restaurants.

### `orders`

Stores order-level information such as:

-   `order_id`
-   `user_id`
-   `restaurant_id`
-   `order_date`
-   `total_amount`
-   `status`
-   `payment_method`

### `orderitem`

Stores individual items belonging to an order:

-   `order_id`
-   `menu_id`
-   `quantity`
-   `item_total`

Relationship overview:

``` text
User
  │
  └── Orders
        │
        └── OrderItems ─── Menu ─── Restaurant
```

## Architecture

The project follows a layered Java web-application structure.

``` text
Browser
   │
   ▼
JSP / HTML / CSS / JavaScript
   │
   ▼
Servlets
   │
   ▼
DAO / DAO Implementation
   │
   ▼
JDBC
   │
   ▼
MySQL
```

### Model Layer

Represents application data.

Examples:

-   `User`
-   `Restaurant`
-   `Menu`
-   `CartItem`
-   `Orders`
-   `OrderItem`

### DAO Layer

Handles database operations through JDBC.

Examples:

-   `UserDAOImpl`
-   `OrderDAOImpl`
-   `OrderItemDAOImpl`

### Servlet Layer

Handles HTTP requests and coordinates application operations.

Examples include:

-   Registration/login servlets
-   Restaurant/menu servlets
-   `CartServlet`
-   `PlaceOrderServlet`
-   Order-history/details servlets
-   Profile servlets

## Session Management

The logged-in user is stored in the HTTP session:

``` java
HttpSession session = request.getSession();
session.setAttribute("loggedInUser", user);
```

Protected pages retrieve the logged-in user:

``` java
User loggedInUser =
    (User) session.getAttribute("loggedInUser");
```

The cart is also stored in the session:

``` java
session.setAttribute("cart", cart);
```

After successful order placement:

``` java
session.removeAttribute("cart");
```

## Challenges Faced

Building FoodHub involved several real development and debugging
challenges.

### JDBC and MySQL Connectivity

Connecting the Java application to MySQL and debugging SQL/JDBC
operations helped me understand database-driven web applications.

### Servlet Mapping

I had to debug servlet URL mappings and ensure that requests were
reaching the correct servlet.

### Session Management

Maintaining login information and cart data across multiple JSP pages
required understanding `HttpSession`.

### Cart Handling

The cart had to maintain selected menu items, quantities, item totals,
and the overall subtotal.

### Foreign-Key Relationships

Order and order-item records have relational dependencies. Incorrect IDs
or insertion order caused database constraint problems that had to be
diagnosed.

### Checkout Form Submission

The delivery-address field initially had a form-structure problem. I
corrected the form structure so the address was submitted correctly to
`PlaceOrderServlet`.

### Payment Method Database Error

One important debugging issue was:

``` text
Data truncated for column 'payment_method'
```

The JSP payment values did not initially match the MySQL `ENUM` values
in the `orders` table. I diagnosed the database definition, aligned the
supported payment values, and tested the order flow again.

### Tomcat Configuration

I also faced Tomcat runtime and port/configuration issues while running
the application through Eclipse.

### JSP and CSS Integration

I had to debug JSP structure, CSS loading, form submission, and
frontend/backend integration during development.

## What I Learned

This project helped me gain practical experience with:

-   Core Java
-   JSP
-   Servlets
-   JDBC
-   MySQL
-   HTTP sessions
-   CRUD operations
-   DAO pattern
-   Layered application structure
-   Form handling
-   SQL queries
-   Relational database relationships
-   Foreign keys
-   Exception handling and debugging
-   Tomcat deployment
-   Git and GitHub workflow

Most importantly, I learned how frontend pages, Java Servlets, JDBC, and
a relational database work together to form a complete web application.

## Testing

The main application flow was tested through:

-   Registration
-   Login
-   Restaurant browsing
-   Menu browsing
-   Add to cart
-   Cart management
-   Checkout
-   Delivery-address update
-   Payment-method selection
-   Order placement
-   Order confirmation
-   Order history
-   Order details
-   Profile update

Database records were also verified using MySQL Workbench.

## Project Structure

The exact Eclipse-generated structure may vary, but the application is
organized around these responsibilities:

``` text
Food_hub/
│
├── Java Resources/
│   └── src/
│       └── com.rsd/
│           ├── DAO/
│           ├── DAOImpl/
│           ├── model/
│           └── Servlet/
│
├── WebContent/
│   ├── css/
│   ├── images/
│   ├── WEB-INF/
│   ├── login.jsp
│   ├── register.jsp
│   ├── checkout.jsp
│   ├── cart.jsp
│   ├── orderSuccess.jsp
│   └── ...
│
└── README.md
```

## How to Run Locally

### Prerequisites

Install and configure:

-   JDK
-   Eclipse IDE
-   Apache Tomcat
-   MySQL Server
-   MySQL Workbench

### 1. Clone the repository

Clone the GitHub repository using GitHub Desktop.

### 2. Import into Eclipse

Import the project as an existing Eclipse Dynamic Web Project.

### 3. Configure MySQL

Create the required FoodHub database and tables.

Configure the JDBC connection with your own local credentials:

``` text
jdbc:mysql://localhost:3306/<database_name>
username=<your_mysql_username>
password=<your_mysql_password>
```

Do not commit real database passwords to GitHub.

### 4. Configure Tomcat

Configure the Apache Tomcat runtime in Eclipse and add the FoodHub
project to the server.

### 5. Run the application

Start Tomcat and open:

``` text
http://localhost:8080/<project-context-path>/
```

## Future Enhancements

Possible future improvements include:

-   Real payment gateway integration
-   Functional coupon/discount system
-   Restaurant/admin dashboard
-   Food search
-   Food and restaurant filtering
-   Order cancellation
-   Order-status tracking
-   Email/SMS notifications
-   Password hashing
-   Stronger authentication and authorization
-   Centralized exception handling
-   REST API
-   Spring Boot migration
-   Cloud deployment
-   Further responsive UI improvements

## Security Note

This is a learning/portfolio project.

Before production use, the application should implement stronger
security practices including password hashing, input validation, secure
session configuration, CSRF protection, authentication/authorization
controls, HTTPS, and secure credential management.

Never upload real passwords, API keys, or database credentials to
GitHub.

## Author

**Dharaneesh R S**

Java Full Stack Developer -- Fresher

**Skills demonstrated:**

`Java` · `JSP` · `Servlets` · `JDBC` · `MySQL` · `HTML` · `CSS` ·
`JavaScript` · `Tomcat`

## Project Status

**Completed as a Java Full Stack learning and portfolio project.**

The project can be further enhanced as I continue learning and applying
new technologies.
