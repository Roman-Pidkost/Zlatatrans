<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="main-container">
<div class="order-car row">
    <script>loadCSS("/resources/css/footer.min.css", document.getElementsByClassName("main-container")[0]);loadCSS("/resources/css/search.min.css", document.getElementsByClassName("main-container")[0]);loadCSS("/resources/css/fav.min.css", document.getElementById("modalTrigger"));(function(){var a=document.getElementsByClassName('nav-order-car')[0];a.className=a.classList+' active';})();loadCSS("/resources/css/main.min.css", document.getElementsByClassName("main-container")[0]);</script>
    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">
        <h1>Замовити автомобіль з європи на Zlatatrans</h1>
        <form:form class="form-horizontal" action="/orderCar" method="post" modelAttribute="order">
            <div class="form-group">
                <label for="make" class="col-sm-2 col-lg-1 control-label">Марка</label>
                <div class="col-sm-9 col-lg-11">
                    <form:input type="text" class="form-control" path="make" placeholder="Марка"/>
                </div>
            </div>
            <div class="form-group">
                <label for="model" class="col-sm-2 col-lg-1 control-label">Модель</label>
                <div class="col-sm-9 col-lg-11">
                    <form:input type="text" class="form-control" path="model" placeholder="Модель"/>
                </div>
            </div>
            <div class="form-group">
                <label for="year" class="col-sm-2 col-lg-1 control-label">Рік</label>
                <div class="col-sm-9 col-lg-11">
                    <form:input type="text" class="form-control" path="year" placeholder="(наприклад: 2012-2016)"/>
                </div>
            </div>
            <div class="form-group">
                <label for="mainOptions" class="col-sm-2 col-lg-1 control-label">Хар.</label>
                <div class="col-sm-9 col-lg-11">
                    <form:input type="text" class="form-control" path="mainOptions" placeholder="(наприклад: Дизель, 2.0, Автомат, Універсал)"/>
                </div>
            </div>
            <div class="form-group">
                <label for="otherOptions" class="col-sm-2 col-lg-1 control-label">Опції</label>
                <div class="col-sm-9 col-lg-11">
                    <form:input type="text" class="form-control" path="otherOptions" placeholder="(наприклад: Кондиціонер, Телевізор, і тд)"/>
                </div>
            </div>
            <div class="form-group">
                <label for="contacts" class="col-sm-2 col-lg-1 control-label">Контакти</label>
                <div class="col-sm-9 col-lg-11">
                    <form:input type="text" class="form-control" path="contacts" placeholder="Ваш номер телефону"/>
                </div>
            </div>
            <button class="btn submitt" type="submit">Відправити заявку</button>
            <div class="text-center">${sended}</div>
        </form:form>
    </div>
    <div class="sr-only">
        <h2>Автомобіль з європи під замовлення Zlatatrans</h2>
    </div>
</div>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="/resources/js/header_favorites.min.js"></script>
<noscript><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></noscript>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>