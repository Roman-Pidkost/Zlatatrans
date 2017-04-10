<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="main-container">
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
                    <li class="active"><a href="/admin/model">Модель</a></li>
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

<div class="row">
    <div class="col-md-3 col-xs-12">
    	<form:form class="form-horizontal filter" action="/admin/model" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search, makeId, _makeId"/>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="search" class="form-control" placeholder="Модель"/>
				</div>
			</div>
			<div class="form-inline">
				<label class="control-label col-sm-12">Марка</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${makes}" itemValue="id" itemLabel="name" path="makeId"/>
				</div>
			</div>
            <div class="col-sm-6 col-sm-offset-3"><button type="submit" class="btn btn-primary">Пошук</button></div>
		</form:form>
    </div>
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/model" method="POST" modelAttribute="model">
                    <div class="form-group">
                        <label for="make" class="col-sm-1 control-label">Марка</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="make" id="make">
                                <%--<form:option value="null" label="Марка" disabled="true" selected="true"/>--%>
                                <form:options items="${makes}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-1 control-label">Назва</label>
                        <div class="col-sm-11">
                            <form:input class="form-control" path="name" id="name" placeholder="Назва" autocomplete="off" />
                        </div>
                        <div class="col-sm-11 col-sm-offset-1"><label class="errors" for="name" style="color:red;text-align:left;" class="control-label"><form:errors path="name"/></label></div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Створити</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-xs-4"><h3>Марка</h3></div>
            <div class="col-md-3 col-xs-4"><h3>Модель</h3></div>
            <div class="col-md-6 col-xs-4"><h3>Оновити/видалити</h3></div>
        </div>
        <c:forEach items="${page.content}" var="model">
            <div class="row">
                <div class="col-md-3 col-xs-4">${model.make.name}</div>
                <div class="col-md-3 col-xs-4">${model.name}</div>
                <div class="col-md-3 col-xs-2"><a class="btn btn-warning" href="/admin/model/update/${model.id}">&#x21ba;</a></div>
                <div class="col-md-3 col-xs-2"><a class="btn btn-danger" href="/admin/model/delete/${model.id}">&#10006;</a></div>
            </div>
        </c:forEach>
    </div>
    <div class="col-md-2 col-xs-12"></div>
    <script>$(".errors").each(function() {var self = $(this); if (!self.html()) {self.hide();}});</script>
</div>
</div>
<style>
    .form-horizontal .control-label{
        text-align: center;
    }
</style>
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