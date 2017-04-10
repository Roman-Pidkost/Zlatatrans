<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="main-container">
<sec:authorize access="!isAuthenticated()">
<div class="row">
	<link rel="stylesheet" href="/resources/css/admin_login.min.css">
<c:if test="${param.fail}">
	<div class="col-sm-12 col-xs-12 text-center">
		Fail to authorize
	</div>
</c:if>

	<form:form class="form-signin" action="/admin" method="post">
		<h2 class="form-signin-heading">Вхід</h2>
		<label for="zlatatrans_admin" class="sr-only">Логін</label>
		<input type="text" name="zlatatrans_admin" id="zlatatrans_admin" class="form-control" placeholder="Логін" required autofocus>
		<label for="password" class="sr-only">Пароль</label>
		<input type="password" name="password" id="password" class="form-control" placeholder="Пароль" required>
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me">Запам'ятати
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Ввійти</button>
	</form:form>
</div>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/commodity">Оголошення</a></li>
					<li><a href="/admin/make">Марка</a></li>
					<li><a href="/admin/model">Модель</a></li>
					<li><a href="/admin/fuelType">Топливо</a></li>
					<li><a href="/admin/drive">Привід</a></li>
					<li><a href="/admin/transmission">Коробка передач</a></li>
					<li><a href="/admin/color">Колір</a></li>
					<li><a href="/admin/bodyType">Тип кузова</a></li>
					<li><a href="/admin/waterMark" class="glyphicon glyphicon-picture"></a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
</sec:authorize>
</div>
<footer>
	<div class="container-fluid">
		<div class="row text-center">
			<div class="footer-nav">
				<a href="/" class="footer-nav-item nav-catalog">Каталог</a>
				<a href="/orderCar" class="footer-nav-item nav-order-car">Замовити автомобіль</a>
				<a href="/howToBuy" class="footer-nav-item nav-how-to-buy">Процедура купівлі</a>
				<a href="/contacts" class="footer-nav-item nav-contacts">Контакти</a>
			</div>
			<div class="created-by">created by pidkostelny@gmail.com</div>
		</div>
	</div>
</footer>
<script>loadCSS("/resources/css/main.min.css", document.getElementById("loadcss"));loadCSS("/resources/css/footer.min.css", document.getElementsByTagName("footer")[0]);loadCSS("/resources/css/search.min.css", document.getElementsByTagName("footer")[0]);loadCSS("/resources/css/fav.min.css", document.getElementById("modalTrigger"));</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="/resources/js/header_favorites.min.js"></script>
<noscript><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></noscript>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>