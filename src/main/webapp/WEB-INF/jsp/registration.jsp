<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<!DOCTYPE html>
			<html>

				<head>
					<meta charset="UTF-8">
						<meta name="viewport" content="width=device-width">
							<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
								<title>Страница регистрации</title>

								<body>
									<div class="register">
										<form:form method="POST" modelAttribute="userForm">
											<span id="hello">
												<h3>Регистрация</h3>
											</span>
											<hr width="70%" size="3" color="black">
												<div class="content">
													<spring:bind path="firstName">
														<div class="form-group ${status.error ? 'has-error' : ''}">
															<form:input id="register_login"  type="text" path="firstName" placeholder="Имя"></form:input>
															<form:errors path="firstName"></form:errors>
														</div>
													</spring:bind>
													<spring:bind path="lastName">
														<div class="form-group ${status.error ? 'has-error' : ''}">
															<form:input id="register_login" type="text" path="lastName" placeholder="Фамилия"></form:input>
															<form:errors path="lastName"></form:errors>
														</div>
													</spring:bind>

													<spring:bind path="email">
														<div class="form-group ${status.error ? 'has-error' : ''}">
															<form:input id="register_login" type="text" path="email" placeholder="Email"></form:input>
															<form:errors path="email"></form:errors>
														</div>
													</spring:bind>
													<spring:bind path="password">
														<div class="form-group ${status.error ? 'has-error' : ''}">
															<form:input id="register_password" type="password" path="password" placeholder="Пароль"></form:input>
															<form:errors path="password"></form:errors>
														</div>
													</spring:bind>
													<spring:bind path="confirmPassword">
														<div class="form-group ${status.error ? 'has-error' : ''}">
															<form:input id="register_password2" type="password" path="confirmPassword" placeholder="Повторитe пароль"></form:input>
															<form:errors path="confirmPassword"></form:errors>
														</div>
													</spring:bind>
												</div>
												<div class="register_button">
													<button type="submit" name="submit" class="c">Зарегистрироваться</button>
												</div>
												<div class="authorize">
													<br>
														<a href="login">Авторизация</a>
													</form:form>
												</div>
											</head>
										</body>
									</html>
