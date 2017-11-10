<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="main-container">
<script>(function(){var a=document.getElementsByClassName('nav-catalog')[0];a.className=a.classList+' active';})();</script>
    <div class="row fast-search">
        <div class="sr-only">
            <h1>Нерозмитнені авто з европи Zlatatrans</h1>
            <h2>На Zlatatrans ви можете знайти для себе вживані авто з Європи за вигідними цінами. Автомобілі нерозмитнені, підлягають під закон 3251</h2>
        </div>
        <div class="row fast-search-nav">
<script>loadCSS("/resources/css/footer.min.css", document.getElementsByClassName("fast-search-nav")[0]);loadCSS("/resources/css/search.min.css", document.getElementsByClassName("fast-search-nav")[0]);loadCSS("/resources/css/fav.min.css", document.getElementById("modalTrigger"));loadCSS("/resources/css/main.min.css", document.getElementsByClassName("main-container")[0]);</script>
            <form:form>
                <div class="fast-search-nav-container col-sm-12 col-md-10 col-sm-offset-0 col-md-offset-1 col-lg-8 col-lg-offset-2">
                    <div class="col-sm-4 col-xs-6">
                        <label for="make_f" class="sr-only">Марка</label>
                        <select class="fast-search-nav-select" id="make_f">
                            <option value="" disabled selected>Марка</option>
                            <c:forEach items="${makes}" var="make">
                                <option value="${make.id}">${make.name} (${make.models.size()})</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-4 col-xs-6">
                        <label for="model_f" class="sr-only">Модель</label>
                        <select class="fast-search-nav-select" id="model_f" disabled>
                            <option value="0" label="Модель" disabled></option>
                        </select>
                    </div>
                    <div class="col-sm-4 col-sm-offset-0 col-xs-6 col-xs-offset-3">
                        <button class="fast-search-nav-button" type="submit" id="search_f">Пошук</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <div class="row full-search">
        <div class="col-lg-8 col-lg-offset-2 col-sm-10 col-sm-offset-1 col-xs-12 col-xs-offset-0">
            <form:form action="/" method="get" class="form-horizontal" modelAttribute="filter">
                <div class="form-group">
                    <label class="sr-only" for="make">Марка</label>
                    <div class="col-xs-6 col-sm-4">
                        <select id="make" name="makeId" class="form-control">
                            <option value="0" disabled selected>Марка</option>
                            <c:forEach items="${makes}" var="make">
                                <option value="${make.id}">${make.name} (${make.models.size()})</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="sr-only" for="model">Модель</label>
                    <div class="col-xs-6 col-sm-4">
                        <form:select class="form-control" path="modelId" id="model">
                            <form:option value="0" label="Модель" disabled="true" selected="true"/>
                        </form:select>
                    </div>
                    <div class="full-search-year col-xs-12 col-sm-4">
                        <div class="row">
                            <label class="col-xs-2" for="minYear">Рік</label>
                            <div class="col-xs-4 col-sm-5">
                                <form:input path="minYear" class="form-control" placeholder="від"/>
                            </div>
                            <div class="col-xs-5">
                                <form:input path="maxYear" class="form-control" placeholder="до"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="transmissionId">Коробка</label>
                    <div class="col-xs-6 col-sm-4">
                        <form:select path="transmissionId" class="form-control">
                            <form:option value="0" label="Коробка" disabled="true"  selected="true" />
                            <form:options items="${transmissions}" itemValue="id" itemLabel="name" />
                        </form:select>
                    </div>
                    <label class="sr-only" for="fuelType">Паливо</label>
                    <div class="col-xs-6 col-sm-4">
                        <form:select path="fuelTypeId" class="form-control" id="fuelType">
                            <form:option value="0" label="Паливо" disabled="true"  selected="true" />
                            <form:options items="${fuelTypes}" itemValue="id" itemLabel="name" />
                        </form:select>
                    </div>
                    <div class="full-search-capacity col-xs-12 col-sm-4">
                        <div class="row">
                            <label class="col-xs-2" for="minCapacity">Об'єм</label>
                            <div class="col-xs-4 col-sm-5">
                                <form:input path="minCapacity" class="form-control" placeholder="від"/>
                            </div>
                            <div class="col-xs-5">
                                <form:input path="maxCapacity" class="form-control" placeholder="до"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="bodyType">Тип кузова</label>
                    <div class="col-xs-6 col-sm-4">
                        <form:select class="form-control" path="bodyTypeId" id="bodyType">
                            <form:option value="0" label="Тип кузова" disabled="true"  selected="true" />
                            <form:options items="${bodyTypes}" itemValue="id" itemLabel="name" />
                        </form:select>
                    </div>
                    <label class="sr-only" for="drive">Привід</label>
                    <div class="col-xs-6 col-sm-4">
                        <form:select class="form-control" path="driveId" id="drive">
                            <form:option value="0" label="Привід" disabled="true"  selected="true" />
                            <form:options items="${drives}" itemValue="id" itemLabel="name" />
                        </form:select>
                    </div>
                    <div class="full-search-price col-xs-12 col-sm-4">
                        <div class="row">
                            <label class="col-xs-2" for="minPrice">Ціна</label>
                            <div class="col-xs-4 col-sm-5">
                                <form:input path="minPrice" class="form-control" placeholder="від"/>
                            </div>
                            <div class="col-xs-5">
                                <form:input path="maxPrice" class="form-control" placeholder="до"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-lg-offset-5 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3 full-search-submit">
                    <button class="fast-search-nav-button" type="submit" id="search">Пошук</button>
                    <div class="sort-container">
                        <div class="dropdown">
                            <button class="sort-tag dropdown-toggle" type="button" data-toggle="dropdown">Сортування <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <custom:sort innerHtml="Ціна: від найдешевших до найдорожчих" paramValue="price"/>
                                <custom:sort innerHtml="Ціна: від найдорожчих до найдешевших" paramValue="price,desc"/>
                                <custom:sort innerHtml="Рік: від найновіших до найстарших" paramValue="year"/>
                                <custom:sort innerHtml="Рік: від найстарших до найновіших" paramValue="year,desc"/>
                            </ul>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <div class="row full-search-button">
    <span class="icon-angle-down"></span>розширений пошук <span class="icon-angle-down"></span>
</div>
    <div class="catalog">
    <%--<div class="col-lg-10 col-lg-offset-1 col-sm-12 col-sm-offset-0  col-xs-10 col-xs-offset-1">--%>
        <c:forEach items="${page.content}" var="commodity">
            <div class="catalog-item">
                <a href="/auto/${commodity.model.make.name}-${commodity.model.name}-${commodity.year}-${String.format("%.2f", commodity.capacity).replace(",", ".")}/${commodity.id}">
                    <h3>${commodity.name}</h3><h4>${commodity.year}</h4>
                    <div class="catalog-item-img">
                        <span class="icon-star catalog-item-img-favorite"></span>
                        <img
                        src="/images/auto_${(commodity.id+1)*33}/${commodity.model.make.name}_${commodity.model.name}_${commodity.year}_${String.format("%.2f", commodity.capacity).replace(",", ".")}_<c:choose><c:when test="${commodity.isSetMainImage}">0</c:when><c:otherwise>1</c:otherwise></c:choose>.jpg?version=${commodity.version}"
                        alt="${commodity.name} ${commodity.year} нерозмитнене авто на Zlatatrans" class="img-responsive">
                    </div>
                </a>
                <div class="catalog-item-description row">
                    <div class="catalog-item-description-price col-xs-12">
                        &#x20ac;<span class="commodityPrice">${commodity.price}</span>
                        <p class="fullPrice"><c:choose><c:when test="${commodity.fullPrice != 0}">з митом: &#x20ac;${commodity.fullPrice}</c:when></c:choose>*</p>
                    </div>
                    <div class="row">
                        <div class="catalog-item-description-label icon-fuel">${commodity.fuelType.name}, ${String.format("%.2f", commodity.capacity).replace(",", ".")} л.</div>
                        <div class="catalog-item-description-label icon-odometer">${commodity.kilometrage} тис. км.</div>
                        <div class="catalog-item-description-label icon-gear">${commodity.transmission.name}</div>
                    </div>
                </div>

            </div>
        </c:forEach>
    <%--</div>--%>
</div>
    <div class="row">
    <div class="col-sm-6 col-sm-offset-3 col-xs-12 col-xs-offset-0 text-center">
        <div class="pageable-wrapper">
            <custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
            <div class="page-size">
                <custom:size posibleSizes="9,18,27" size="${page.size}" />
            </div>
        </div>
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
<script src="/resources/js/main_page_v2.min.js"></script>
<script src="/resources/js/header_favorites.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<noscript><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></noscript>
