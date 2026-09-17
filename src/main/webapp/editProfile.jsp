<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rsd.model.User"%>

<%
User user = (User) request.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Profile | FoodHub</title>
<link rel="stylesheet" href="css/editProfile.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
</head>

<body>

<div class="container">
    <h2>✏ Update Profile Information</h2>

    <% if(user != null) { %>
    <form action="updateProfile" method="post">
        <input type="hidden" name="userId" value="<%=user.getUser_id()%>">

        <div>
            <label>Username</label>
            <input type="text" name="username" value="<%=user.getUsername()%>" required>
        </div>

        <div>
            <label>Email Address</label>
            <input type="email" name="email" value="<%=user.getEmail()%>" required>
        </div>

        <div>
            <label>Phone Number</label>
            <input type="text" name="phone" value="<%=user.getPhone()%>" required>
        </div>

        <div>
            <label>Delivery Address</label>
            <textarea name="address" rows="4" required><%=user.getAddress()%></textarea>
        </div>

        <button type="submit">
            Save Profile Changes
        </button>
    </form>
    <% } %>
</div>

</body>
</html>