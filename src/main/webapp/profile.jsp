<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.rsd.model.User"%>

<%
User user = (User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Profile | FoodHub</title>
<link rel="stylesheet" href="css/profile.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
</head>

<body>

<div class="profile-container">
    <div class="profile-card">
        <div class="profile-header">
            <div class="avatar-circle">👤</div>
            <h1><%=user != null ? user.getUsername() : "User Profile"%></h1>
            <p style="font-size: 13.5px; opacity: 0.9;">FoodHub Valued Customer</p>
        </div>

        <% if(user != null) { %>
        <div class="profile-body">
            <div class="info">
                <label>User Name</label>
                <p><%=user.getUsername()%></p>
            </div>

            <div class="info">
                <label>Email Address</label>
                <p><%=user.getEmail()%></p>
            </div>

            <div class="info full-width">
                <label>Default Address</label>
                <p><%=user.getAddress()%></p>
            </div>

            <div class="info">
                <label>Account Role</label>
                <p><%=user.getRole()%></p>
            </div>

            <div class="info">
                <label>Member Since</label>
                <p><%=user.getCreated_date()%></p>
            </div>

            <div class="info full-width">
                <label>Last Logged In</label>
                <p><%=user.getLastdatelogin()%></p>
            </div>
        </div>
        <% } %>

        <div class="buttons">
            <a href="editProfile" class="btn">✏ Edit Profile</a>
            <a href="RestaurantServlet" class="btn home">🏠 Home</a>
        </div>
    </div>
</div>

</body>
</html>