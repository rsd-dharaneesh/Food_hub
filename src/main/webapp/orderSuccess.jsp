<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Placed Successfully | FoodHub</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    background: linear-gradient(135deg, rgba(226, 55, 68, 0.95), rgba(28, 28, 28, 0.95)),
                url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600') center/cover no-repeat;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
}

.container {
    background: #FFFFFF;
    width: 100%;
    max-width: 480px;
    padding: 48px 36px;
    border-radius: 24px;
    text-align: center;
    box-shadow: 0 20px 50px rgba(0, 0, 0, 0.3);
    animation: zoomIn 0.5s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

@keyframes zoomIn {
    from { opacity: 0; transform: scale(0.8); }
    to { opacity: 1; transform: scale(1); }
}

.success-badge {
    width: 90px;
    height: 90px;
    background: #E8F5E9;
    border: 4px solid #4CAF50;
    color: #2E7D32;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 46px;
    margin: 0 auto 20px auto;
    box-shadow: 0 10px 25px rgba(76, 175, 80, 0.25);
}

h1 {
    color: #1C1C1C;
    font-size: 24px;
    font-weight: 800;
    margin-bottom: 8px;
}

p {
    font-size: 14.5px;
    color: #696969;
    margin-bottom: 18px;
}

.order-id-box {
    background: #FAFAFA;
    border: 1.5px dashed #E23744;
    padding: 12px 20px;
    border-radius: 12px;
    display: inline-block;
    margin-bottom: 28px;
}

.order-id {
    font-size: 17px;
    color: #E23744;
    font-weight: 800;
}

.btn-group {
    display: flex;
    flex-direction: column;
    gap: 12px;
}

.btn {
    display: block;
    text-decoration: none;
    background: linear-gradient(135deg, #E23744, #D32F2F);
    color: white;
    padding: 14px 28px;
    border-radius: 12px;
    font-size: 15.5px;
    font-weight: 700;
    transition: all 0.3s ease;
    box-shadow: 0 6px 18px rgba(226, 55, 68, 0.35);
}

.btn:hover {
    background: linear-gradient(135deg, #D32F2F, #B71C1C);
    transform: translateY(-2px);
}

.btn-secondary {
    background: #1C1C1C;
    box-shadow: 0 6px 18px rgba(0, 0, 0, 0.2);
}

.btn-secondary:hover {
    background: #333333;
}
</style>
</head>

<body>

<div class="container">
    <div class="success-badge">
        ✓
    </div>

    <h1>Order Placed Successfully!</h1>
    <p>Thank you for ordering with FoodHub! Your food is now being prepared by the chef.</p>

    <div class="order-id-box">
        <span class="order-id">
            Order Reference ID: #<%= request.getParameter("orderId") != null ? request.getParameter("orderId") : "" %>
        </span>
    </div>

    <div class="btn-group">
        <a href="myOrders" class="btn">
            📦 Track & View My Orders
        </a>
        <a href="RestaurantServlet" class="btn btn-secondary">
            🍕 Continue Shopping
        </a>
    </div>
</div>

</body>
</html>