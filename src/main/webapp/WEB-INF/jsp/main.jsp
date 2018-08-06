<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
      <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html lang="en" dir="ltr">

          <head>
            <meta charset="utf-8">
              <title>MyShop</title>
              <link rel="stylesheet" type="text/css" href="css/main.css"></head>

              <body>
                <header id="sticky">
                  <div class="heading clearfix">
                    <div class="container">
                      <nav>
                        <ul class="menu">
                          <li class="user">
                            <a href="admin">${user.email}</a>
                          </li>
                          <li class="logOut">
                            <a href="logout">Выйти</a>
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
                                  <ul id="show-cart"></ul>
                                </div>
                                <div>
                                  <br>
                                    <div>Общяя стоимиость:
                                      <span id="total-cart"></span>
                                    </div>
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
                                  <form:form method="POST" modelAttribute="searchString">
                                    <div class="content">
                                      <spring:bind path="name">
                                        <form:input path="name" id="searchInput" name="name" type="text" placeholder="Название товара"/>
                                      </spring:bind>
                                    </div>
                                    <div class="search_button">
                                      <button type="submit" class="c">Найти</button>
                                    </div>
                                  </form:form>
                                  <c:if test="${!empty search}">
                                    <div class="items">
                                      <img src="${search.img}" alt="product">
                                        <a class="button" href="#popup${search.id}">${search.name}</a>
                                        <div id="popup${searchsearch.id}" class="overlay">
                                          <div class="popup">
                                            <a class="close" href="#">&times;</a>
                                            <div class="content">
                                              <a>${search.name}</a>
                                              <b>${search.price} руб.</b>
                                              <c class="add-to-cart" href="#" data-img="${search.img}" data-name="${search.name}" data-price="${search.price}">В корзину
                                              </c>
                                              <img src="${search.img}" alt="product"></div>
                                            </div>
                                          </div>
                                        </div>
                                      </c:if>
                                    </div>
                                  </div>
                                </li2>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </header>
                      <c:forEach items="${list}" var="product">
                        <section>
                          <div class="container">
                            <div class="products clearfix">
                              <div class="titles">
                                <div class="title_fist" id="sticky2">
                                  <h3>${product.name}</h3>
                                </div>
                                <div>
                                  <c:forEach items="${product.products}" var="product">
                                    <div class="items">
                                      <img src="${product.img}" alt="product">
                                        <a class="button" href="#popup${product.id}">${product.name}</a>
                                        <div id="popup${product.id}" class="overlay">
                                          <div class="popup">
                                            <a class="close" href="#">&times;</a>
                                            <div class="content">
                                              <a>${product.name}</a>
                                              <b>${product.price} руб.</b>
                                              <c class="add-to-cart" href="#" data-img="${product.img}" data-name="${product.name}" data-price="${product.price}">В корзину
                                              </c>
                                              <img src="${product.img}" alt="product"></div>
                                            </div>
                                          </div>
                                        </div>
                                      </c:forEach>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </section>
                          </c:forEach>
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
                                                                  function displayCart() {
                                                                    var cartArray = shoppingCart.listCart();
                                                                    console.log(cartArray);
                                                                    var output = "";
                                                                    for (var i in cartArray) {
                                                                      output += "<li> <img src='" + cartArray[i].img + "'> <name>" + cartArray[i].name + "</name> <price> Цена: " + cartArray[i].price + " Руб. </price> <button1 href=# class='delete-item' data-name='" + cartArray[i].name + "'>X</button1> </li>";
                                                                    }
                                                                    $("#show-cart").html(output);
                                                                    $("#count-cart").html(shoppingCart.countCart());
                                                                    $("#total-cart").html(shoppingCart.totalCart() + " Руб.");
                                                                  }

                                                                  $("#show-cart").on("click", ".delete-item", function (event) {
                                                                    var name = $(this).attr("data-name");
                                                                    shoppingCart.removeItemFromCartAll(name);
                                                                    displayCart();
                                                                  });
                                                                  displayCart();
                                                                </script>

                                                              </html>
