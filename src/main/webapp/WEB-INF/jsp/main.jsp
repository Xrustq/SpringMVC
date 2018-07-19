<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>MyShop</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>
<header id="sticky">
    <div class="heading clearfix">
        <div class="container">
            <nav>
                <ul class="menu">
                    <li class="user">
                        ${user.email}
                    </li>
                    <li class="logOut">
                        <a href="authorize">Выйти</a>
                    </li>
                    <li2 class="basket">
                        <a href="#openModal2" class="info">Корзина
                            <count id="count-cart"></count>
                        </a>
                        <div id="openModal2" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close1">&times;</a>
                                <h1>Корзина</h1>
                                <div style="height:270px;width:500px; overflow : auto;">
                                    <ul id="show-cart">
                                    </ul>
                                </div>
                                <div>
                                    <br>
                                    <div>Общяя стоимиость: <span id="total-cart"></span></div>
                                    <div>
                                        <!-- <button id="clear-cart">Очистить корзину</button> -->
                                        <div class="order">Оформить</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li2>
                    <li2 class="search">
                        <a href="#searchModal">Поиск..</a>

                        <div id="searchModal" class="searchModal">
                            <div>
                                <a href="#close" title="Close" class="close1">&times;</a>
                                <h1>Поиск</h1>
                                <div class="content">
                                    <input id="searchInput" type="text" placeholder="Название товара">
                                </div>
                                <div class="search_button">
                                    <a href="#" class="c">Найти</a>
                                </div>
                                <div class="items">
                                    <img src="img/square.png" alt="product">
                                    <a class="button" href="#popup1">product1</a>
                                    <div class="overlay">
                                        <div class="popup">
                                            <a class="close" href="#">&times;</a>
                                            <div class="content">
                                                <a>product1</a>
                                                <b>86 руб.</b>
                                                <c class="add-to-cart" href="#" data-img="img/square.png"
                                                   data-name="product1" data-price="86">В корзину
                                                </c>
                                                <img src="img/square.png" alt="product">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="items">
                                    <img src="img/square.png" alt="product">
                                    <a class="button" href="#popup2">product2</a>
                                    <div class="overlay">
                                        <div class="popup">
                                            <a class="close" href="#">&times;</a>
                                            <div class="content">
                                                <a>product2</a>
                                                <b>16 руб.</b>
                                                <c class="add-to-cart" href="#" data-img="img/square.png"
                                                   data-name="product2" data-price="16">В корзину
                                                </c>
                                                <img src="img/square.png" alt="product">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li2>
                </ul>
            </nav>
        </div>
    </div>
</header>
<section>
    <div class="container">
        <div class="products clearfix">
            <div class="titles">
                <div class="title_fist" id="sticky2">
                    <h3>Категория товаров 1</h3>
                </div>
                <div id="products1"></div>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="titles">
            <div class="products clearfix">
                <div class="title_fist" id="sticky2">
                    <h3>Категория товаров 2</h3>
                </div>
                <c:forEach items="${list}" var="product">
                    <div class="items">
                        <img src="img/square.png" alt="product">
                        <a class="button" href="#popup${product.id}">${product.name}</a>
                        <div id="popup${product.id}" class="overlay">
                            <div class="popup">
                                <a class="close" href="#">&times;</a>
                                <div class="content">
                                    <a>${product.name}</a>
                                    <b>${product.price} руб.</b>
                                    <c class="add-to-cart" href="#" data-img="img/square.png"
                                       data-name="${product.name}"
                                       data-price="${product.price}">В корзину
                                    </c>
                                    <img src="img/square.png" alt="product">
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<footer>
    <div class="container">
        <hr width="100%" size="2" color="black">
        <p>Любая текстовая информация для футера</p>
    </div>
</footer>
</body>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/shoppingCart.js"></script>
<script src="js/products.js"></script>

<script>
    $(".add-to-cart").click(function (event) {
        event.preventDefault();
        var name = $(this).attr("data-name");
        var price = Number($(this).attr("data-price"));
        var img = $(this).attr("data-img");
        shoppingCart.addItemToCart(name, price, 1, img);
        displayCart();
    });
    $("#clear-cart").click(function (event) {
        shoppingCart.clearCart();
        displayCart();
    });

    function displayCart() {
        var cartArray = shoppingCart.listCart();
        console.log(cartArray);
        var output = "";
        for (var i in cartArray) {
            output += "<li>" + " <img src='" + cartArray[i].img + "'>" +
                " <name>" + cartArray[i].name + "</name>" +
                " <price> Цена: " + cartArray[i].price + " Руб." + " </price>" +
                " <button1 href=" + "#" + " class='delete-item' data-name='" +
                cartArray[i].name + "'>X</button1>" +
                " </li>";
        }
        $("#show-cart").html(output);
        $("#count-cart").html(shoppingCart.countCart());
        $("#total-cart").html(shoppingCart.totalCart() + " " + "Руб.");
    }

    $("#show-cart").on("click", ".delete-item", function (event) {
        var name = $(this).attr("data-name");
        shoppingCart.removeItemFromCartAll(name);
        displayCart();
    });
    $("#show-cart").on("click", ".subtract-item", function (event) {
        var name = $(this).attr("data-name");
        shoppingCart.removeItemFromCart(name);
        displayCart();
    });
    $("#show-cart").on("click", ".plus-item", function (event) {
        var name = $(this).attr("data-name");
        shoppingCart.addItemToCart(name, 0, 1);
        displayCart();
    });
    $("#show-cart").on("change", ".item-count", function (event) {
        var name = $(this).attr("data-name");
        var count = Number($(this).val());
        shoppingCart.setCountForItem(name, count);
        displayCart();
    });
    displayCart();
</script>

</html>
