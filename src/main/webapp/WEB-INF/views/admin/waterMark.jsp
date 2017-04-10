<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
                        <li><a href="/admin/model">Модель</a></li>
                        <li><a href="/admin/fuelType">Топливо</a></li>
                        <li><a href="/admin/drive">Привід</a></li>
                        <li><a href="/admin/transmission">Коробка передач</a></li>
                        <li><a href="/admin/color">Колір</a></li>
                        <li><a href="/admin/bodyType">Тип кузова</a></li>
                        <li class="active"><a href="/admin/waterMark" class="glyphicon glyphicon-picture"></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="col-xs-8 col-xs-offset-2">
            <div class="row">
                <form:form class="form-horizontal" action="/admin/waterMark"  method="POST"  enctype="multipart/form-data" modelAttribute="waterMark">
                    <div class="position-label col-sm-4 text-center">
                        <h3 style="margin-top: 40px; color: rgba(0,0,0,.6);">Розміщення</h3>
                        <form:radiobutton path="position" value="top-left" cssClass="position-top-left" />
                        <form:radiobutton path="position" value="top" cssClass="position-top" />
                        <form:radiobutton path="position" value="top-right" cssClass="position-top-right" />
                        <form:radiobutton path="position" value="center-left" cssClass="position-center-left" />
                        <form:radiobutton path="position" value="center" cssClass="position-center" />
                        <form:radiobutton path="position" value="center-right" cssClass="position-center-right" />
                        <form:radiobutton path="position" value="bottom-left" cssClass="position-bottom-left" />
                        <form:radiobutton path="position" value="bottom" cssClass="position-bottom" checked="true"/>
                        <form:radiobutton path="position" value="bottom-right" cssClass="position-bottom-right"/>
                    </div>
                    <div class="col-sm-8">
                        <form:input class="btn btn-secondary" type="file" path="images" accept="image/jpeg,image/png" multiple="multiple" cssStyle="padding-left: 0;"/>
                        <button type="submit" class="btn btn-primary">Обробити</button>
                        <a class="btn btn-secondary" href="/archive/watermarkered.zip">Скачати останній</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<style>
    .position-label {
        position: relative;
        min-height: 200px;
        border: 1px dashed #aaa;
    }
    .position-top-left, .position-top, .position-top-right,
    .position-center-left, .position-center, .position-center-right,
    .position-bottom-left, .position-bottom, .position-bottom-right {
        position: absolute;
        display: block;
        height:20px;
        width: 20px;
    }
    .position-top-left {
        top: 10px;
        left: 10px
    }
     .position-top {
        top: 10px;
        left: 50%;
        margin-left: -10px!important;
    }
    .position-top-right {
        top: 10px;
        right: 10px;
    }
     .position-center-left {
        top: 50%;
        margin-top: -10px!important;
        left: 10px
    }
     .position-center {
        top: 50%;
        margin-top: -10px!important;
        left: 50%;
        margin-left: -10px!important;
    }
     .position-center-right {
        top: 50%;
        margin-top: -10px!important;
        right: 10px;
    }
    .position-bottom-left {
        bottom: 10px;
        left: 10px
    }
     .position-bottom {
        bottom: 10px;
        left: 50%;
        margin-left: -10px!important;
    }
    .position-bottom-right {
        bottom: 10px;
        right: 10px;
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