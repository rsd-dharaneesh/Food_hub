<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | FoodHub</title>
    <link rel="stylesheet" href="css/login.css?v=2">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<body>

<div class="login-container">
    <div class="brand-header">
        <div class="brand-logo">
            🍷 Food<span>Hub</span>
        </div>
        <h1>Welcome Back</h1>
        <p>Log in to discover delicious meals delivered fast.</p>
    </div>

    <% if(request.getParameter("success") != null){ %>
        <div class="success-message">
            <span>✅</span> Registration Successful! Please Login.
        </div>
    <% } %>
    
    <% if(request.getParameter("error") != null){ %>
        <div class="error-message">
            <span>⚠️</span> Invalid Email or Password!
        </div>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="input-group">
            <label for="email">Email Address</label>
            <input
                type="email"
                id="email"
                class="input-field"
                name="email"
                placeholder="e.g. alex@example.com"
                required>
        </div>

        <div class="input-group">
            <label for="password">Password</label>
            <input
                type="password"
                id="password"
                class="input-field"
                name="password"
                placeholder="Enter your password"
                required>
        </div>

        <div class="show-password">
            <input
                type="checkbox"
                id="showPassword">
            <label for="showPassword">
                Show Password
            </label>
        </div>

        <button type="submit">
            Log In
        </button>
    </form>

    <div class="register-link">
        New to FoodHub?
        <a href="register.jsp">
            Create an account
        </a>
    </div>
</div>

<script>
const password = document.getElementById("password");
const checkbox = document.getElementById("showPassword");

checkbox.addEventListener("change", function(){
    password.type = this.checked ? "text" : "password";
});
</script>

</body>
</html>