<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.rsd.model.Orders"%>

<%
List<Orders> orders = (List<Orders>)request.getAttribute("orders");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Orders | FoodHub</title>
<link rel="stylesheet" href="css/orderHistory.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
</head>

<body>

<div class="container">
    <div class="page-header">
        <h1>📦 My Order History</h1>
        <a href="RestaurantServlet">← Back to Restaurants</a>
    </div>

    <% if(orders == null || orders.isEmpty()){ %>
        <div class="empty-orders">
            <h2>No Past Orders Found</h2>
            <p style="color:#707070; margin-top:8px;">You haven't placed any orders yet. Start ordering delicious meals!</p>
        </div>
    <% } else { %>
        <% for(Orders order : orders){ %>
            <div class="order-card">
                <div class="order-main-info">
                    <h2>Order #<%=order.getOrderId()%></h2>
                    <div class="order-meta">
                        <span>📅 <%=order.getOrderDate()%></span>
                        <span class="payment-tag">💳 <%=order.getPaymentMethod()%></span>
                    </div>
                    <div>
                        <span class="status-tag">
                            ✅ <%=order.getStatus()%>
                        </span>
                    </div>
                </div>

                <div class="order-price-col">
                    <div class="total-amt">
                        ₹<%=order.getTotalAmount()%>
                    </div>
                    <a href="orderDetails?orderId=<%=order.getOrderId()%>" class="btn-details">
                        View Order Details →
                    </a>
                </div>
            </div>
        <% } %>
    <% } %>
</div>

</body>
</html>