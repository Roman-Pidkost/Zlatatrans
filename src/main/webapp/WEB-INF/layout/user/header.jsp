<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<header>
    <nav class="row top-header">
        <div class="search-form col-xs-12 col-sm-10">
            <form:form class="form-horizontal" action="/search" method="get">
                <div class="form-group">
                    <label for="search_field" class="sr-only">Пошук</label>
                        <input name="search" id="search_field" class="form-control"/>
                    <button type="submit" id="search_submitt"></button>
                </div>
            </form:form>
        </div>
        <div class="col-xs-7 mobile-logo">
            <a href="/" title="Доступні авто з європи - ZLATATRANS" class="logo-container"><img src="/resources/img/logo.png" alt="Доступні авто з європи - ZLATATRANS" style="height:40px;width:auto;" class="logo"></a>
        </div>
        <div class="col-xs-5 col-sm-2 col-md-2 pull-right">
            <div class="row nav-buttons">
                <div class="col-xs-4 col-sm-6">
                    <a class="icon-search" href="/" title="Пошук"></a>
                </div>
                <div class="col-xs-4 col-sm-6">
                    <a href="/" class="icon-star" title="Обрані"></a>
                </div>
                <div class="col-xs-4 ico-menu">
                    <a href="/" title="Меню">
                        <span class="ico-menu-part"></span>
                        <span class="ico-menu-part"></span>
                        <span class="ico-menu-part"></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="separator row hidden-xs hidden-md hidden-lg"></div>
        <div class="col-sm-9 col-sm-offset-2 col-md-10 col-md-offset-0 top-header-nav">
            <a href="/" title="Доступні авто з європи - ZLATATRANS" class="logo-container hidden-xs hidden-sm"><img src="/resources/img/logo.png" alt="Доступні авто з європи - ZLATATRANS" style="height:50px;width:auto;" class="logo"></a>
            <a href="/" title="Каталог автомобілів в наявності" class="top-header-nav-item nav-catalog">Каталог</a>
            <a href="/orderCar" title="Замовити автомобіль з європи" class="top-header-nav-item nav-order-car">Замовити автомобіль</a>
            <a href="/howToBuy" title="Купівля, розмитнення і оформлення автомобіля" class="top-header-nav-item nav-how-to-buy">Процедура купівлі</a>
            <a href="/contacts" title="Наші контакти" class="top-header-nav-item nav-contacts">Контакти</a>
        </div>
    </nav>
    <div class="separator row"></div>
</header>
<button type="button" id="modalTrigger" class="btn btn-primary sr-only" data-toggle="modal" data-target="#favorites"></button>
<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="favorites">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <div class="row">
                <div class="col-xs-12" id="favorites-container">
                    <div class="text-center"><h5>Список обраних пустий</h5></div>
                </div>
            </div>
        </div>
    </div>
</div>
