<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="main-container">
    <script>loadCSS("/resources/css/main.min.css", document.getElementById("loadcss"));loadCSS("/resources/css/footer.min.css", document.getElementsByClassName("main-container")[0]);loadCSS("/resources/css/search.min.css", document.getElementsByClassName("main-container")[0]);loadCSS("/resources/css/fav.min.css", document.getElementById("modalTrigger"));</script>
    <div class="row">
        <div class="commodity-name col-xs-12 col-xs-offset-1 col-sm-6"><h1><span>${auto.year} </span>${auto.name}</h1></div>
        <div class="sr-only">
            <h1>${auto.model.make.name} ${auto.model.name} ${auto.capacity} ${auto.fuelType.name} ${auto.year}</h1>
            <h2>Недороге авто з европи</h2>
        </div>
        <div class="col-xs-11 col-xs-offset-1 col-sm-offset-0 col-sm-5 commodity-year">
            &#x20ac;<span id="commodity-price">${auto.price}</span></span>
        </div>
        <div class="commodity-slider col-sm-6 col-sm-offset-1 col-xs-12 col-xs-offset-0">
            <div class="commodity-slider-for">
            <c:forEach var="i" begin="${auto.isSetMainImage ? 0 : 1}" end="${ auto.isSetMainImage ? auto.imagesCount - 1 : auto.imagesCount}">
                    <img src="/images/auto_${(auto.id+1)*33}/${auto.model.make.name}_${auto.model.name}_${auto.year}_${String.format("%.2f", auto.capacity).replace(",", ".")}_${i}.jpg?version=${auto.version}" alt="${auto.name} ${auto.year}" class="img-responsive">
            </c:forEach>
            </div>
            <div class="commodity-slider-nav">
                <c:forEach var="i" begin="${auto.isSetMainImage ? 0 : 1}" end="${ auto.isSetMainImage ? auto.imagesCount - 1 : auto.imagesCount }">
                    <img src="/images/auto_${(auto.id+1)*33}/${auto.model.make.name}_${auto.model.name}_${auto.year}_${String.format("%.2f", auto.capacity).replace(",", ".")}_${i}.jpg?version=${auto.version}" alt="${auto.name} ${auto.year}" class="img-responsive">
                </c:forEach>
            </div>
        </div>
        <div class="commodity-description col-lg-4 col-sm-5">
            <div class="contacts col-sm-12 col-xs-10 col-xs-offset-1 col-sm-offset-0">
                <dl>
                    <dd class="contacts-phone">+380-67-670-07-93</dd>
                    <dd class="contacts-phone">+48-536-526-720</dd>
                    <dd class="contacts-mail">zlata.supp@gmail.com</dd>
                </dl>
            </div>
            <div class="col-xs-1 hidden-sm hidden-md hidden-lg"></div>
            <div class="commodity-description-item col-sm-12 col-xs-10 col-xs-offset-1 col-sm-offset-0">
                <table>
                    <tr>
                        <td>Тип кузова:</td>
                        <td>${auto.bodyType.name}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>дверей: ${auto.doorsCount}, місць: ${auto.seatsCount}</td>
                    </tr>
                    <tr>
                        <td>Двигун:</td>
                        <td>${String.format("%.2f", auto.capacity).replace(",", ".")} л., ${auto.fuelType.name}, ${auto.power}кВт/${Integer.valueOf(auto.power*1.34)}к.с.</td>
                    </tr>
                    <tr>
                        <td>Пробіг:</td>
                        <td>${auto.kilometrage} тис. км.</td>
                    </tr>
                    <tr>
                        <td>Коробка:</td>
                        <td>${auto.transmission.name}</td>
                    </tr>
                    <tr>
                        <td>Привід:</td>
                        <td>${auto.drive.name}</td>
                    </tr>
                    <tr>
                        <td>Колір:</td>
                        <td>${auto.color.name}</td>
                    </tr>
                    <c:if test="${auto.fullPrice != 0 && auto.fullPrice != auto.price}">
                        <tr>
                            <td>З митом:</td>
                            <td>&#x20ac;<span  id="commodity-fullPrice">${auto.fullPrice}</span>*</td>
                        </tr>
                        <tr class="commodity-fullPrice">
                            <td></td>
                            <td></td>
                        </tr>
                    </c:if>
                </table>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
    <div class="separator comm-separ row"></div>
    <div class="row">
        <div class="col-xs-1 hidden-sm hidden-md hidden-lg"> </div>
        <div class="col-xs-10 col-sm-11 col-sm-offset-1">
            <div class="add-options-container">
                <h4 class="add-options">Додаткові опції:</h4>
                <p class="add-options-item"><c:if test="${auto.hasAbs}">ABS<c:if test="${auto.hasEsp || auto.hasAirbag}">,</c:if> </c:if><c:if test="${auto.hasEsp}">ESP<c:if test="${auto.hasAirbag}">,</c:if>  </c:if><c:if test="${auto.hasAirbag}">Airbag</c:if></p>
                <p class="add-options-item add-options-comfort"><c:if test="${auto.hasConditioner}">кондиціонер<c:if test="${auto.hasClimateControl || auto.hasLeather || auto.hasHatch || auto.hasParktronic}">,</c:if> </c:if><c:if test="${auto.hasClimateControl}">клімат-контроль<c:if test="${auto.hasLeather || auto.hasHatch || auto.hasParktronic}">,</c:if> </c:if><c:if test="${auto.hasLeather}">шкіра<c:if test="${auto.hasHatch || auto.hasParktronic}">,</c:if> </c:if><c:if test="${auto.hasHatch}">люк<c:if test="${auto.hasParktronic}">,</c:if> </c:if><c:if test="${auto.hasParktronic}">парктронік</c:if></p>
                <p class="add-options-item"><c:if test="${auto.hasHeatedSteeringWheel || auto.hasHeatedMirrors || hasHeatedSeats}">Підігрів: </c:if><c:if test="${auto.hasHeatedSteeringWheel}">руля<c:if test="${auto.hasHeatedMirrors || hasHeatedSeats}">,</c:if> </c:if><c:if test="${auto.hasHeatedSeats}">сидінь<c:if test="${auto.hasHeatedMirrors}">,</c:if> </c:if><c:if test="${auto.hasHeatedMirrors}">зеркал</c:if></p>
                <p class="add-options-item"><c:if test="${auto.hasGlassHoist || auto.hasElectricSeats || auto.hasElectricMirrors || hasGlassHoist}">Ел.: </c:if><c:if test="${auto.hasGlassHoist}">склопідйомники<c:if test="${auto.hasElectricSeats || auto.hasElectricMirrors}">,</c:if> </c:if><c:if test="${auto.hasElectricSeats}">сидіння<c:if test="${auto.hasElectricMirrors}">,</c:if> </c:if><c:if test="${auto.hasElectricMirrors}">дзеркала</c:if></p>
                <c:if test="${ !auto.description.isEmpty()}">
                    <h4 class="add-options">Опис:</h4>
                    <p class="add-options-item">${auto.description}</p>
                </c:if>
            </div>
        </div>
    </div>
    </div>
<div class="row" style="text-align:center;font-size:12px;color:#757173;margin:5px 0;"><c:if test="${auto.fullPrice != 0}">*повна ціна вказана орієнтовно, уточнюйте по телефону</c:if></div>
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
<script src="/resources/js/slick.min.js"></script>
<script src="/resources/js/auto.min.js"></script>
<script src="/resources/js/header_favorites.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<noscript><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></noscript>
<noscript><link rel="stylesheet" href="/resources/css/commodity.min.css"></noscript>