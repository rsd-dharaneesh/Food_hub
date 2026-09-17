<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.rsd.model.Restaurant"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FoodHub - Order Food Online from Top Restaurants</title>
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
    background: #f8f8f8;
    color: #1c1c1c;
}

/* ================= NAVBAR ================= */
.navbar {
    background: #ffffff;
    height: 72px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 8%;
    position: sticky;
    top: 0;
    z-index: 1000;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.06);
}

.logo {
    font-size: 32px;
    font-weight: 800;
    color: #E23744;
    letter-spacing: -1px;
    text-decoration: none;
    display: flex;
    align-items: center;
    gap: 6px;
}

.logo span {
    color: #1c1c1c;
}

.nav-search {
    display: flex;
    align-items: center;
    background: #f4f4f4;
    border-radius: 12px;
    padding: 8px 16px;
    width: 380px;
    border: 1px solid #e8e8e8;
    transition: all 0.3s ease;
}

.nav-search:focus-within {
    background: #ffffff;
    border-color: #E23744;
    box-shadow: 0 0 0 3px rgba(226, 55, 68, 0.12);
}

.nav-search input {
    border: none;
    background: transparent;
    outline: none;
    width: 100%;
    font-size: 14px;
    color: #1c1c1c;
    margin-left: 8px;
}

.nav-links {
    display: flex;
    align-items: center;
    gap: 24px;
}

.nav-links a {
    color: #363636;
    text-decoration: none;
    font-size: 15px;
    font-weight: 600;
    padding: 8px 16px;
    border-radius: 10px;
    transition: all 0.25s ease;
    display: flex;
    align-items: center;
    gap: 6px;
}

.nav-links a:hover,
.nav-links a.active {
    color: #E23744;
    background: rgba(226, 55, 68, 0.06);
}

.btn-signin {
    background: #E23744 !important;
    color: #ffffff !important;
    padding: 9px 20px !important;
    border-radius: 10px;
    box-shadow: 0 4px 14px rgba(226, 55, 68, 0.3);
}

.btn-signin:hover {
    background: #d32f2f !important;
    transform: translateY(-1px);
}

/* ================= HERO SECTION ================= */
.hero {
    background: linear-gradient(135deg, rgba(28, 28, 28, 0.88), rgba(226, 55, 68, 0.82)),
                url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600') center/cover no-repeat;
    color: white;
    text-align: center;
    padding: 70px 20px;
    position: relative;
}

.hero-content {
    max-width: 800px;
    margin: 0 auto;
}

.hero h1 {
    font-size: 46px;
    font-weight: 800;
    letter-spacing: -0.5px;
    margin-bottom: 12px;
    line-height: 1.2;
}

.hero p {
    font-size: 18px;
    color: #f0f0f0;
    font-weight: 400;
    margin-bottom: 25px;
}

.location-badge {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    background: rgba(255, 255, 255, 0.18);
    backdrop-filter: blur(10px);
    padding: 8px 18px;
    border-radius: 30px;
    font-size: 14px;
    font-weight: 500;
    border: 1px solid rgba(255, 255, 255, 0.25);
}

/* ================= CATEGORIES SECTION ================= */
.categories-wrapper {
    max-width: 1300px;
    margin: 35px auto 10px auto;
    padding: 0 25px;
}

.section-heading {
    font-size: 26px;
    font-weight: 700;
    color: #1c1c1c;
    margin-bottom: 20px;
    display: flex;
    align-items: center;
    gap: 10px;
}

.categories-grid {
    display: flex;
    gap: 14px;
    overflow-x: auto;
    padding-bottom: 15px;
    scrollbar-width: thin;
}

.categories-grid::-webkit-scrollbar {
    height: 6px;
}

.categories-grid::-webkit-scrollbar-thumb {
    background: #e23744;
    border-radius: 10px;
}

.category-pill {
    background: #ffffff;
    border: 1.5px solid #e8e8e8;
    padding: 10px 22px;
    border-radius: 30px;
    font-size: 14px;
    font-weight: 600;
    color: #4f4f4f;
    cursor: pointer;
    white-space: nowrap;
    transition: all 0.25s ease;
    display: flex;
    align-items: center;
    gap: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.03);
}

.category-pill:hover,
.category-pill.active {
    background: #E23744;
    color: #ffffff;
    border-color: #E23744;
    box-shadow: 0 6px 16px rgba(226, 55, 68, 0.25);
}

/* ================= RESTAURANT GRID ================= */
.main-container {
    max-width: 1300px;
    margin: 20px auto 60px auto;
    padding: 0 25px;
}

.restaurant-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(360px, 1fr));
    gap: 32px;
}

.card {
    background: #ffffff;
    border-radius: 20px;
    overflow: hidden;
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.05);
    transition: all 0.35s ease;
    border: 1px solid #f0f0f0;
    display: flex;
    flex-direction: column;
}

.card:hover {
    transform: translateY(-8px);
    box-shadow: 0 16px 36px rgba(0, 0, 0, 0.12);
}

.img-wrapper {
    position: relative;
    width: 100%;
    height: 230px;
    overflow: hidden;
}

.card img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.5s ease;
}

.card:hover img {
    transform: scale(1.08);
}

.offer-badge {
    position: absolute;
    bottom: 14px;
    left: 14px;
    background: rgba(28, 28, 28, 0.85);
    backdrop-filter: blur(8px);
    color: #ffffff;
    padding: 6px 14px;
    border-radius: 8px;
    font-size: 13px;
    font-weight: 700;
    border-left: 4px solid #E23744;
    display: flex;
    align-items: center;
    gap: 6px;
}

.content {
    padding: 22px;
    display: flex;
    flex-direction: column;
    flex: 1;
}

.top {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 8px;
}

.top h2 {
    font-size: 20px;
    font-weight: 700;
    color: #1c1c1c;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    max-width: 240px;
}

.rating {
    background: #24963F;
    color: white;
    padding: 4px 10px;
    border-radius: 8px;
    font-weight: 700;
    font-size: 13px;
    display: flex;
    align-items: center;
    gap: 4px;
    box-shadow: 0 2px 8px rgba(36, 150, 63, 0.25);
}

.meta-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 12px;
}

.cuisine {
    color: #E23744;
    font-weight: 600;
    font-size: 14px;
}

.time {
    background: #FFF0F1;
    color: #E23744;
    padding: 4px 12px;
    border-radius: 20px;
    font-weight: 600;
    font-size: 12.5px;
    display: inline-flex;
    align-items: center;
    gap: 4px;
}

.addr {
    color: #707070;
    font-size: 13.5px;
    margin-bottom: 14px;
    display: flex;
    align-items: center;
    gap: 6px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.desc {
    color: #555555;
    font-size: 13.5px;
    line-height: 1.5;
    margin-bottom: 20px;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
}

.btn-wrapper {
    margin-top: auto;
}

.btn {
    display: block;
    text-align: center;
    background: #E23744;
    color: white;
    text-decoration: none;
    padding: 13px;
    border-radius: 12px;
    font-weight: 700;
    font-size: 15px;
    transition: all 0.3s ease;
    box-shadow: 0 4px 14px rgba(226, 55, 68, 0.3);
}

.btn:hover {
    background: #d32f2f;
    transform: translateY(-2px);
    box-shadow: 0 8px 20px rgba(226, 55, 68, 0.4);
}

.empty-state {
    grid-column: 1 / -1;
    text-align: center;
    padding: 80px 20px;
    background: #ffffff;
    border-radius: 20px;
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.05);
}

.empty-state h2 {
    color: #E23744;
    font-size: 26px;
    margin-bottom: 10px;
}

.empty-state p {
    color: #707070;
    font-size: 16px;
}

/* ================= FOOTER ================= */
footer {
    background: #1C1C1C;
    color: #ffffff;
    padding: 50px 8% 30px 8%;
    margin-top: 60px;
}

.footer-top {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 30px;
    border-bottom: 1px solid #333333;
    margin-bottom: 30px;
}

.footer-logo {
    font-size: 32px;
    font-weight: 800;
    color: #E23744;
}

.footer-logo span {
    color: #ffffff;
}

.footer-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 30px;
    margin-bottom: 40px;
}

.footer-col h4 {
    font-size: 16px;
    font-weight: 700;
    margin-bottom: 16px;
    color: #ffffff;
    letter-spacing: 0.5px;
}

.footer-col ul {
    list-style: none;
}

.footer-col ul li {
    margin-bottom: 10px;
}

.footer-col ul li a {
    color: #9c9c9c;
    text-decoration: none;
    font-size: 14px;
    transition: color 0.2s ease;
}

.footer-col ul li a:hover {
    color: #E23744;
}

.footer-bottom {
    text-align: center;
    color: #808080;
    font-size: 14px;
    padding-top: 20px;
    border-top: 1px solid #292929;
}
</style>
</head>

<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar">
    <a href="#" class="logo">
        🍷 Food<span>Hub</span>
    </a>

    <div class="nav-search">
        🔍 <input type="text" id="restaurantSearch" placeholder="Search for restaurants, cuisine or dishes...">
    </div>

    <div class="nav-links">
        <a href="#" class="active">🏠 Home</a>
        <a href="login.jsp" class="btn-signin">🔑 Sign In</a>
        <a href="cart">🛒 Cart</a>
        <a href="profile">👤 Profile</a>
    </div>
</nav>

<!-- ================= HERO ================= -->
<section class="hero">
    <div class="hero-content">
        <div class="location-badge">📍 Delivering to Bengaluru, India</div>
        <h1 style="margin-top: 15px;">Discover the Best Food & Drinks</h1>
        <p>Order online from your favorite top-rated restaurants with superfast delivery.</p>
    </div>
</section>

<!-- ================= CATEGORIES ================= -->
<div class="categories-wrapper">
    <div class="section-heading">
        🍕 Explore Top Cuisines
    </div>
    <div class="categories-grid">
        <button class="category-pill active" onclick="filterCategory('All', this)">🍽 All Cuisines</button>
        <button class="category-pill" onclick="filterCategory('South Indian', this)">🥞 South Indian</button>
        <button class="category-pill" onclick="filterCategory('North Indian', this)">🍛 North Indian</button>
        <button class="category-pill" onclick="filterCategory('Italian', this)">🍕 Italian</button>
        <button class="category-pill" onclick="filterCategory('Fast Food', this)">🍔 Fast Food</button>
        <button class="category-pill" onclick="filterCategory('Chinese', this)">🍜 Chinese</button>
        <button class="category-pill" onclick="filterCategory('Biryani', this)">🍲 Biryani</button>
        <button class="category-pill" onclick="filterCategory('Desserts', this)">🍰 Desserts</button>
    </div>
</div>

<!-- ================= RESTAURANT GRID ================= -->
<div class="main-container">
    <div class="section-heading">
        🛵 Top Restaurants Near You
    </div>

    <div class="restaurant-grid" id="restaurantGrid">
    <%
    List<Restaurant> allRestaurants = (List<Restaurant>)request.getAttribute("allRestaurants");

    if(allRestaurants != null && !allRestaurants.isEmpty()){
        for(Restaurant restaurant : allRestaurants){
    %>

        <div class="card" data-name="<%=restaurant.getName().toLowerCase()%>" data-cuisine="<%=restaurant.getCuisineType().toLowerCase()%>">
            <div class="img-wrapper">
                <img src="<%=restaurant.getImagePath()%>" alt="<%=restaurant.getName()%>">
                <div class="offer-badge">🏷 50% OFF up to ₹100</div>
            </div>

            <div class="content">
                <div class="top">
                    <h2><%=restaurant.getName()%></h2>
                    <span class="rating">⭐ <%=restaurant.getRating()%></span>
                </div>

                <div class="meta-row">
                    <span class="cuisine"><%=restaurant.getCuisineType()%></span>
                    <span class="time">⏱ <%=restaurant.getDeliveryTime()%> mins</span>
                </div>

                <div class="addr">
                    📍 <%=restaurant.getAddress()%>
                </div>

                <div class="desc">
                    Authentic delicious meals prepared fresh daily by expert chefs.
                </div>

                <div class="btn-wrapper">
                    <a href="menu?restaurantId=<%=restaurant.getRestaurantId()%>" class="btn">
                        View Menu & Order
                    </a>
                </div>
            </div>
        </div>

    <%
        }
    } else {
    %>
        <div class="empty-state">
            <h2>🍽 No Restaurants Available</h2>
            <p>We couldn't find any restaurants at this moment. Please check back soon!</p>
        </div>
    <%
    }
    %>
    </div>
</div>

<!-- ================= FOOTER ================= -->
<footer>
    <div class="footer-top">
        <div class="footer-logo">
            🍷 Food<span>Hub</span>
        </div>
    </div>

    <div class="footer-grid">
        <div class="footer-col">
            <h4>ABOUT FOODHUB</h4>
            <ul>
                <li><a href="#">Who We Are</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">Work With Us</a></li>
                <li><a href="#">Investor Relations</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>FOR RESTAURANTS</h4>
            <ul>
                <li><a href="#">Partner With Us</a></li>
                <li><a href="#">Apps For You</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>LEARN MORE</h4>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Security</a></li>
                <li><a href="#">Terms of Service</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>SOCIAL LINKS</h4>
            <ul>
                <li><a href="#">Facebook</a></li>
                <li><a href="#">Instagram</a></li>
                <li><a href="#">Twitter</a></li>
            </ul>
        </div>
    </div>

    <div class="footer-bottom">
        © 2026 FoodHub Inc. All rights reserved. | Fresh Food, Fast Delivery.
    </div>
</footer>

<script>
// Search Filter
const searchInput = document.getElementById('restaurantSearch');
const cards = document.querySelectorAll('.restaurant-grid .card');

if (searchInput) {
    searchInput.addEventListener('input', function() {
        const query = this.value.toLowerCase().trim();
        cards.forEach(card => {
            const name = card.getAttribute('data-name') || '';
            const cuisine = card.getAttribute('data-cuisine') || '';
            if (name.includes(query) || cuisine.includes(query)) {
                card.style.display = 'flex';
            } else {
                card.style.display = 'none';
            }
        });
    });
}

// Category Filter
function filterCategory(category, buttonEl) {
    document.querySelectorAll('.category-pill').forEach(btn => btn.classList.remove('active'));
    buttonEl.classList.add('active');

    const catLower = category.toLowerCase();
    cards.forEach(card => {
        const cuisine = card.getAttribute('data-cuisine') || '';
        if (catLower === 'all' || cuisine.includes(catLower)) {
            card.style.display = 'flex';
        } else {
            card.style.display = 'none';
        }
    });
}
</script>

</body>
</html>