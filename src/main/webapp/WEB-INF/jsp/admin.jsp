<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
      <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

        <!DOCTYPE html>
        <html>
          <head>
            <meta http-equiv="Content-Type" content="text/html;">
              <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
                <title>Страница админимтратора</title>
              </head>
              <body>
                <h3>${greeting} ${name}</h3>
                <a href="/main">На главную</a>
                <br>
                  <h1>Добавить продукт</h1>
                  <c:url var="addAction" value="/admin/add"></c:url>

                  <%-- Форма ввода --%>

                    <form:form action="${addAction}" modelAttribute="product">
                      <table>
                        <tr>
                          <td>
                            <form:label path="id">
                              <spring:message text="ID"/>
                            </form:label>
                          </td>
                          <td>
                            <form:input path="id"/>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <form:label path="name">
                              <spring:message text="Название"/>
                            </form:label>
                          </td>
                          <td>
                            <form:input path="name"/>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <form:label path="price">
                              <spring:message text="Цена"/>
                            </form:label>
                          </td>
                          <td>
                            <form:input path="price"/>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <form:label path="img">
                              <spring:message text="Изображение"/>
                            </form:label>
                          </td>
                          <td>
                            <form:input path="img"/>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <form:label path="category">
                              <spring:message text="Категория"/>
                            </form:label>
                          </td>
                          <td>
                            <form:input path="category"/>
                          </td>
                        </tr>
                        <tr>
                          <td colspan="2">
                            <c:if test="${!empty product.name}">
                              <input type="submit" value="<spring:message text="Редактировать товар"/>"/>
                            </c:if>
                            <c:if test="${empty product.name}">
                              <input type="submit" value="<spring:message text="Добавить товар"/>"/>
                            </c:if>
                          </td>
                        </tr>
                      </table>
                    </form:form>
                    <br>
                      <c:forEach items="${list}" var="categories">
                      <br>
                        <h2>${categories.name}</h2>
                        <table class="blueTable">
                          <tr>
                            <th>Id</th>
                            <th>Название</th>
                            <th>Цена</th>
                            <th>Изображение</th>
                            <th>Редактировать</th>
                            <th>Удалить</th>
                          </tr>
                          <c:forEach items="${categories.products}" var="product">
                            <tr>
                              <td>${product.id}</td>
                              <td>${product.name}</td>
                              <td>${product.price}</td>
                              <td style="width: 60px;">
                                <img src="${pageContext.request.contextPath}/${product.img}" alt="product" height="80" width="80"></td>
                                <td style="width: 60px;">
                                  <a href="<c:url value='admin/edit/${product.id}' />">
                                    <img src="${pageContext.request.contextPath}/img/edit.png" width="20" height="20"/></a>
                                </td>
                                <td style="width: 60px;">
                                  <a href="<c:url value='admin/delete/${product.id}/${product.category}' />">&times;</a>
                                </td>
                              </tr>
                            </c:forEach>
                          </table>
                        </body>
                      </c:forEach>
                    </html>
