<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>

		<head>
			<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width">
					<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
						<title>Страница авторизации</title>

						<body>
							<div class="register">
								<form:form method="POST" modelAttribute="userForm">
									<span id="hello">
										<h3>Авторизация</h3>
									</span>
									<hr width="70%" size="3" color="black">
										<div class="content">
											<spring:bind path="email">
												<div class="form-group ${status.error ? 'has-error' : ''}">
													<form:input id="register_login" type="text" name="email" path="email" placeholder="Email"></form:input>
													<form:errors path="email"></form:errors>
												</div>
											</spring:bind>
											<spring:bind path="password">
												<div class="form-group ${status.error ? 'has-error' : ''}">
													<form:input id="register_password" type="password" name="password" path="password" placeholder="Пароль"></form:input>
													<form:errors path="password"></form:errors>
												</div>
											</spring:bind>
										</div>
										<div class="register_button">
											<button type="submit" name="submit" class="c">Вход</button>
										</div>
										<br>
											<a href="registration">Зарегистрироваться</a>
										</div>
									</form:form>
								</body>
							</head>
						</html>
