<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | FoodHub</title>
    <link rel="stylesheet" href="css/register.css?v=2">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<body>

<div class="register-container">
    <div class="brand-header">
        <div class="brand-logo">
            🍷 Food<span>Hub</span>
        </div>
        <h1>Create Account</h1>
        <p>Join FoodHub and enjoy fast food delivery from top restaurants.</p>
    </div>

    <form action="RegisterServlet" method="post">
        <div class="input-group">
            <label for="username">Full Name</label>
            <input
                type="text"
                id="username"
                class="input-field"
                name="username"
                placeholder="e.g. John Doe"
                required>
        </div>

        <div class="input-group">
            <label for="email">Email Address</label>
            <input
                type="email"
                id="email"
                class="input-field"
                name="email"
                placeholder="e.g. john@example.com"
                required>
        </div>

        <div class="input-group">
            <label for="phone">Phone Number</label>
            <input
                type="text"
                id="phone"
                class="input-field"
                name="phone"
                placeholder="e.g. +91 9876543210"
                required>
        </div>

        <div class="input-group">
            <label for="password">Password</label>
            <input
                type="password"
                id="password"
                class="input-field"
                name="password"
                placeholder="Create a strong password"
                required>
        </div>

        <div class="input-group">
            <label for="address">Delivery Address</label>
            <textarea
                id="address"
                class="input-field"
                name="address"
                placeholder="Enter complete house address, street, city..."
                required></textarea>
        </div>

        <button type="submit">
            Create Account
        </button>
    </form>

    <div class="login-link">
        Already have an account?
        <a href="login.jsp">
            Log In
        </a>
    </div>
</div>

</body>
</html>