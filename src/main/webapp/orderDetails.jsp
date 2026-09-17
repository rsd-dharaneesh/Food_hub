<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.rsd.model.Orders"%>
<%@ page import="com.rsd.model.OrderItem"%>
<%@ page import="com.rsd.model.Menu"%>
<%@ page import="com.rsd.DAOImpl.MenuDAOImpl"%>

<%!
public String getDishImageUrl(Menu menu) {
    if (menu == null) return "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500&auto=format&fit=crop&q=80";
    String url = menu.getImageUrl();
    if (url != null && !url.trim().isEmpty() && !url.equalsIgnoreCase("null") && !url.endsWith("null") && url.startsWith("http")) {
        return url;
    }
    String name = (menu.getItemName() != null ? menu.getItemName() : "").toLowerCase();
    
    if (name.contains("chicken 65") || name.contains("chicken65")) {
        return "https://images.unsplash.com/photo-1610057099443-f63a1188d79f?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("apollo fish")) {
        return "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("double ka meetha")) {
        return "https://images.unsplash.com/photo-1601050690597-df0568f70950?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("pepsi") || name.contains("coke") || name.contains("cold drink") || name.contains("ice tea") || name.contains("lime soda") || name.contains("mojito")) {
        return "https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("thalappakatti chicken") || name.contains("lazeez chicken biryani") || name.contains("chicken biryani")) {
        return "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("mutton biryani")) {
        return "https://images.unsplash.com/photo-1633945274405-b6c8069047b0?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("paneer biryani") || name.contains("paneer tikka")) {
        return "https://images.unsplash.com/photo-1567188040759-fb8a883dc6d8?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("biryani")) {
        return "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("mutton sukka") || name.contains("mutton chukka")) {
        return "https://images.unsplash.com/photo-1544025162-d76694265947?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("pepper chicken") || name.contains("bbq chicken")) {
        return "https://images.unsplash.com/photo-1598515214211-89d3c73ae83b?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("egg fried rice")) {
        return "https://images.unsplash.com/photo-1603133872878-684f208fb84b?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("chicken gravy") || name.contains("chicken curry")) {
        return "https://images.unsplash.com/photo-1603894584373-5ac82b2ae398?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("raita")) {
        return "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("jigarthanda") || name.contains("shake") || name.contains("smoothie") || name.contains("krusher")) {
        return "https://images.unsplash.com/photo-1572490122747-3968b75cc699?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("gulab jamun") || name.contains("jangiri") || name.contains("kesari") || name.contains("payasam")) {
        return "https://images.unsplash.com/photo-1601050690597-df0568f70950?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("meals") || name.contains("thali")) {
        return "https://images.unsplash.com/photo-1610192244261-3f33de3f55e4?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("masala dosa") || name.contains("rava dosa") || name.contains("paper roast")) {
        return "https://images.unsplash.com/photo-1668236543090-82eba5ee5976?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("poori")) {
        return "https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("idli") || name.contains("vada")) {
        return "https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("pongal")) {
        return "https://images.unsplash.com/photo-1589301760014-d929f3979dbc?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("coffee") || name.contains("tea") || name.contains("chai")) {
        return "https://images.unsplash.com/photo-1514432324607-a09d9b4aefdd?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("badam milk") || name.contains("lassi")) {
        return "https://images.unsplash.com/photo-1544145945-f90425340c7e?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("margherita") || name.contains("farmhouse") || name.contains("veg extravaganza") || name.contains("pizza")) {
        return "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("garlic bread")) {
        return "https://images.unsplash.com/photo-1573145959957-65707ec2c7d4?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("choco lava cake") || name.contains("mousse") || name.contains("hot chocolate")) {
        return "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("potato wedges") || name.contains("french fries") || name.contains("fries")) {
        return "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("brownie")) {
        return "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("singer") || name.contains("whopper") || name.contains("burger")) {
        return "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("wings") || name.contains("popcorn") || name.contains("nuggets") || name.contains("bucket")) {
        return "https://images.unsplash.com/photo-1562967914-608f82629710?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("sundae") || name.contains("flurry") || name.contains("ice cream") || name.contains("scoop") || name.contains("fudge")) {
        return "https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("sub") || name.contains("delight")) {
        return "https://images.unsplash.com/photo-1509722747041-616f39b57569?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("salad")) {
        return "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("cookies")) {
        return "https://images.unsplash.com/photo-1499636136210-6f4ee915583e?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("momo")) {
        return "https://images.unsplash.com/photo-1625220194771-7ebdea0b70b9?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("waffle")) {
        return "https://images.unsplash.com/photo-1562376502-6f769499c886?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("thukpa")) {
        return "https://images.unsplash.com/photo-1547592165-e1d17f8e05cc?w=500&auto=format&fit=crop&q=80";
    } else if (name.contains("buffet")) {
        return "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=500&auto=format&fit=crop&q=80";
    }
    return "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500&auto=format&fit=crop&q=80";
}
%>

<%
Orders order = (Orders) request.getAttribute("order");
List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderItems");
MenuDAOImpl menuDAO = (MenuDAOImpl) request.getAttribute("menuDAO");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Details | FoodHub</title>
<link rel="stylesheet" href="css/orderDetails.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
</head>

<body>

<div class="container">
    <h1>🧾 Order Details</h1>

    <% if(order != null) { %>
    <div class="order-info-grid">
        <div class="info-item">
            <label>Order Reference ID</label>
            <span>#<%=order.getOrderId()%></span>
        </div>

        <div class="info-item">
            <label>Status</label>
            <span style="color:#2E7D32;">✅ <%=order.getStatus()%></span>
        </div>

        <div class="info-item">
            <label>Payment Method</label>
            <span>💳 <%=order.getPaymentMethod()%></span>
        </div>

        <div class="info-item">
            <label>Total Paid</label>
            <span style="color:#E23744;">₹<%=order.getTotalAmount()%></span>
        </div>
    </div>
    <% } %>

    <div class="table-title">🍽 Ordered Items</div>

    <table>
        <thead>
            <tr>
                <th>Item Name</th>
                <th style="text-align:center;">Qty</th>
                <th style="text-align:right;">Price</th>
                <th style="text-align:right;">Total</th>
            </tr>
        </thead>
        <tbody>
        <%
        if(orderItems != null && menuDAO != null){
            for(OrderItem item : orderItems){
                Menu menu = menuDAO.getMenu(item.getMenuId());
                if(menu != null){
        %>
            <tr>
                <td>
                    <div class="food-cell">
                        <img 
                            src="<%=getDishImageUrl(menu)%>" 
                            alt="<%=menu.getItemName()%>" 
                            class="food-image"
                            onerror="this.onerror=null; this.src='https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500&auto=format&fit=crop&q=80';">
                        <span style="font-weight:700;"><%=menu.getItemName()%></span>
                    </div>
                </td>
                <td style="text-align:center; font-weight:700;"><%=item.getQuantity()%></td>
                <td style="text-align:right;">₹<%=menu.getPrice()%></td>
                <td style="text-align:right; font-weight:800; color:#E23744;">₹<%=item.getItemTotal()%></td>
            </tr>
        <%
                }
            }
        }
        %>
        </tbody>
    </table>

    <a href="myOrders" class="btn-back">
        ← Back to My Orders
    </a>
</div>

</body>
</html>