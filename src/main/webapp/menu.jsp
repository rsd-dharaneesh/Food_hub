<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.rsd.model.Menu"%>
<%@ page import="com.rsd.model.Restaurant"%>
<%@ page import="com.rsd.model.CartItem"%>

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
Restaurant restaurant = (Restaurant) request.getAttribute("restaurant");
List<Menu> menus = (List<Menu>) request.getAttribute("menus");
List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");

int cartCount = 0;
double cartTotal = 0;

if(cart != null){
    for(CartItem item : cart){
        cartCount += item.getQuantity();
        cartTotal += item.getMenu().getPrice() * item.getQuantity();
    }
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%=restaurant != null ? restaurant.getName() : "Menu"%> | FoodHub</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
</head>

<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar">
    <a href="RestaurantServlet" class="logo">
        🍷 Food<span>Hub</span>
    </a>

    <div class="search-box">
        <input
            type="text"
            id="searchInput"
            placeholder="Search delicious dishes in <%=restaurant != null ? restaurant.getName() : "menu"%>...">
    </div>

    <ul>
        <li>
            <a href="RestaurantServlet">
                🏠 Home
            </a>
        </li>
        <li>
            <a href="cart">
                🛒 Cart
                <span class="cart-count" id="cartCount">
                    <%=cartCount%>
                </span>
            </a>
        </li>
        <li>
            <a href="myOrders">
                📦 My Orders
            </a>
        </li>
        <li>
            <a href="profile">
                👤 Profile
            </a>
        </li>
    </ul>
</nav>

<!-- ================= RESTAURANT BANNER ================= -->
<% if(restaurant != null) { %>
<div class="restaurant-banner">
    <div class="restaurant-image">
        <img src="<%=restaurant.getImagePath()%>" alt="<%=restaurant.getName()%>">
    </div>

    <div class="restaurant-details">
        <h1><%=restaurant.getName()%></h1>

        <div class="banner-meta">
            <span class="rating">⭐ <%=restaurant.getRating()%></span>
            <span class="cuisine-tag">🍽 <%=restaurant.getCuisineType()%></span>
            <span class="time-tag">🛵 <%=restaurant.getDeliveryTime()%> mins delivery</span>
        </div>

        <p class="addr-text">
            📍 <%=restaurant.getAddress()%>
        </p>
    </div>
</div>
<% } %>

<!-- ================= CATEGORIES ================= -->
<div class="categories">
    <button class="active" data-category="All">All Items</button>
    <button data-category="Biryani">Biryani</button>
    <button data-category="Chicken">Chicken</button>
    <button data-category="Mutton">Mutton</button>
    <button data-category="Rice">Rice</button>
    <button data-category="Dessert">Dessert</button>
    <button data-category="Beverages">Beverages</button>
</div>

<!-- ================= MENU SECTION ================= -->
<div class="menu-section">
    <h2 class="section-title">
        🍽 Recommended Dishes
    </h2>

    <div class="menu-grid">
    <%
    if(menus != null && !menus.isEmpty()){
        for(Menu menu : menus){
    %>

    <div class="menu-card" data-name="<%=menu.getItemName()%>" data-category="<%=menu.getCategory()%>">
        <div class="menu-info">
            <div class="badge-row">
                <% if(menu.getFoodType() != null && menu.getFoodType().equalsIgnoreCase("Veg")){ %>
                    <span class="veg-icon" title="Vegetarian"></span>
                <% } else { %>
                    <span class="nonveg-icon" title="Non-Vegetarian"></span>
                <% } %>

                <% if(menu.isBestseller()){ %>
                    <span class="bestseller">🔥 BESTSELLER</span>
                <% } %>
            </div>

            <h3><%=menu.getItemName()%></h3>

            <div class="food-rating">
                ⭐ <%=menu.getRating()%> / 5
            </div>

            <p class="description">
                <%=menu.getDescription()%>
            </p>

            <div class="price">
                ₹ <%=String.format("%.2f", menu.getPrice())%>
            </div>
        </div>

        <div class="menu-image">
            <img 
                src="<%=getDishImageUrl(menu)%>" 
                alt="<%=menu.getItemName()%>" 
                loading="lazy"
                onerror="this.onerror=null; this.src='https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500&auto=format&fit=crop&q=80';">

            <form action="cart" method="post">
                <input type="hidden" name="menuId" value="<%=menu.getMenuId()%>">
                <button type="submit" class="add-btn">
                    + ADD
                </button>
            </form>
        </div>
    </div>

    <%
        }
    } else {
    %>
        <div style="grid-column:1/-1; text-align:center; padding:80px; background:white; border-radius:20px; box-shadow:0 5px 20px rgba(0,0,0,.05);">
            <h2>🍽 No Menu Items Available</h2>
            <p style="margin-top:10px; color:#707070;">Sorry! This restaurant has not uploaded its menu items yet.</p>
        </div>
    <%
    }
    %>
    </div>
</div>

<!-- ================= FLOATING CART ================= -->
<div class="floating-cart">
    <h3>🛒 Shopping Cart</h3>
    <p><span id="cartItems"><%=cartCount%></span> Item(s) selected</p>
    <h2>₹ <span id="cartTotal"><%=String.format("%.2f", cartTotal)%></span></h2>
    <a href="cart.jsp" style="text-decoration:none;">
        <button>View Cart & Checkout →</button>
    </a>
</div>

<!-- ================= JAVASCRIPT ================= -->
<script>
// Search Filter
const searchInput = document.getElementById("searchInput");
const cards = document.querySelectorAll(".menu-card");

if(searchInput) {
    searchInput.addEventListener("keyup", function () {
        let value = this.value.toLowerCase();
        cards.forEach(card => {
            let foodName = card.dataset.name ? card.dataset.name.toLowerCase() : "";
            if (foodName.includes(value)) {
                card.style.display = "flex";
            } else {
                card.style.display = "none";
            }
        });
    });
}

// Category Filter
const categoryButtons = document.querySelectorAll(".categories button");
categoryButtons.forEach(button => {
    button.addEventListener("click", function () {
        categoryButtons.forEach(btn => btn.classList.remove("active"));
        this.classList.add("active");

        let category = this.dataset.category.toLowerCase();
        cards.forEach(card => {
            let foodCategory = card.dataset.category ? card.dataset.category.toLowerCase() : "";
            if (category === "all" || foodCategory === category) {
                card.style.display = "flex";
            } else {
                card.style.display = "none";
            }
        });
    });
});

// AJAX Add to Cart
document.querySelectorAll("form[action='cart']").forEach(form => {
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        const menuId = this.querySelector("input[name='menuId']").value;

        fetch("<%=request.getContextPath()%>/cart", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
                "X-Requested-With": "XMLHttpRequest"
            },
            body: "menuId=" + encodeURIComponent(menuId)
        })
        .then(response => response.json())
        .then(data => {
            document.getElementById("cartCount").innerText = data.cartCount;
            document.getElementById("cartItems").innerText = data.cartCount;
            document.getElementById("cartTotal").innerText = Number(data.cartTotal).toFixed(2);
            showToast("✅ Item added to cart");
        })
        .catch(err => {
            console.error(err);
            showToast("✅ Item added to cart");
        });
    });
});

// Toast Notification
function showToast(message){
    const toast = document.createElement("div");
    toast.innerHTML = message;
    toast.style.position = "fixed";
    toast.style.top = "90px";
    toast.style.right = "25px";
    toast.style.background = "#E23744";
    toast.style.color = "white";
    toast.style.padding = "14px 24px";
    toast.style.borderRadius = "12px";
    toast.style.fontWeight = "700";
    toast.style.boxShadow = "0 10px 30px rgba(226,55,68,0.35)";
    toast.style.zIndex = "99999";
    document.body.appendChild(toast);

    setTimeout(() => {
        toast.remove();
    }, 1800);
}
</script>

</body>
</html>
