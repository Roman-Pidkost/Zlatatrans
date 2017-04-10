<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                    <li class="active"><a href="/admin/commodity">Оголошення</a></li>
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

<div class="row">
    <div class="col-md-2 col-xs-12">
        <form:form class="form-horizontal filter" action="/admin/commodity" method="GET" modelAttribute="filter">
            <custom:hiddenInputs excludeParams="minPrice, maxPrice, minYear, maxYear, minCapacity, maxCapacity, makeId, fuelTypeId, transmissionId, bodyTypeId, _makeId, _fuelTypeId, _transmissionId, _bodyTypeId"/>
            <h4 class="search icon-angle-down">Пошук</h4>
            <div class="search-container">
            <div class="form-group">
                <label class="control-label col-sm-12">Марка</label>
                <div class="col-sm-12">
                    <form:checkboxes element="div" items="${makes}" itemValue="id" itemLabel="name" path="makeId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-12">Паливо</label>
                <div class="col-sm-12">
                    <form:checkboxes element="div" items="${fuelTypes}" itemValue="id" itemLabel="name" path="fuelTypeId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-12">Коробка</label>
                <div class="col-sm-12">
                    <form:checkboxes element="div" items="${transmissions}" itemValue="id" itemLabel="name" path="transmissionId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-12">Тип кузова</label>
                <div class="col-sm-12">
                    <form:checkboxes element="div" items="${bodyTypes}" itemValue="id" itemLabel="name" path="bodyTypeId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-12">Рік</label>
                <div class="col-sm-6">
                    <form:input path="minYear" class="form-control" placeholder="від"/>
                </div>
                <div class="col-sm-6">
                    <form:input path="maxYear" class="form-control" placeholder="до"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-12">Об'єм</label>
                <div class="col-sm-6">
                    <form:input path="minCapacity" class="form-control" placeholder="від"/>
                </div>
                <div class="col-sm-6">
                    <form:input path="maxCapacity" class="form-control" placeholder="до"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-12">Ціна</label>
                <div class="col-sm-6">
                    <form:input path="minPrice" class="form-control" placeholder="від"/>
                </div>
                <div class="col-sm-6">
                    <form:input path="maxPrice" class="form-control" placeholder="до"/>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3"><button type="submit" class="btn btn-secondary">Пошук</button></div>
            </div>
        </form:form>
    </div>
    <div class="col-xs-12 hidden-md hidden-lg">
        <div class="col-md-6 col-xs-4 col-xs-offset-2 text-center">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button"
                        data-toggle="dropdown">
                    Sort <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <custom:sort innerHtml="Ім'я за зростанням" paramValue="name" />
                    <custom:sort innerHtml="Ім'я за спаданням" paramValue="name,desc" />
                    <custom:sort innerHtml="Модель за зростанням" paramValue="model.name" />
                    <custom:sort innerHtml="Модель за спаданням" paramValue="model.name,desc" />
                    <custom:sort innerHtml="Ціна за зростанням" paramValue="price" />
                    <custom:sort innerHtml="Ціна за спаданням" paramValue="price,desc" />
                </ul>
            </div>
        </div>
        <div class="col-md-6 col-xs-4 col-xs-offset-2 text-center">
            <custom:size posibleSizes="10,20,40,80" size="${page.size}" />
        </div>
    </div>
    <div class="col-md-8 col-xs-12 initialization">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/commodity" method="POST" modelAttribute="commodity" enctype="multipart/form-data">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-5 col-sm-offset-7"><label for="model" style="color:red;text-align:left;" class="control-label"><form:errors path="model"/></label></div>
                        </div>
                        <label class="col-sm-1 control-label" for="make">Марка</label>
                        <div class="col-sm-5">
                            <select id="make" class="form-control">
                                <option value="" disabled selected>Марка</option>
                                <c:forEach items="${makes}" var="make">
                                    <option value="${make.id}">${make.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <label for="model" class="col-sm-1 control-label">Модель</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="model" id="model">
                                <form:option value="0" label="Модель" disabled="true" selected="true"/>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row errors" style="margin: auto 5px;">
                            <div class="col-sm-5 col-sm-offset-1"><label for="year" style="color:red;text-align:left;" class="control-label"><form:errors path="year"/></label></div>
                            <div class="col-sm-5 col-sm-offset-1"><label for="kilometrage" style="color:red;text-align:left;" class="control-label"><form:errors path="kilometrage"/></label></div>
                        </div>
                        <label for="year" class="col-sm-1 control-label">Рік</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="year" id="year" placeholder="Рік" autocomplete="off" />
                        </div>

                        <label for="kilometrage" class="col-sm-1 control-label">Пробіг</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="kilometrage" id="kilometrage" placeholder="Пробіг (тис. км.)" autocomplete="off" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row errors">
                            <div class="col-sm-5 col-sm-offset-7"><label for="capacity" style="color:red;text-align:left;" class="control-label"><form:errors path="capacity"/></label></div>
                        </div>
                        <label for="fuelType" class="col-sm-1 control-label">Паливо</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="fuelType" id="fuelType">
                                <form:option value="0" label="Тип палива" disabled="true" selected="true"/>
                                <form:options items="${fuelTypes}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>
                        <label for="capacity" class="col-sm-1 control-label">Об'єм</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="capacity" id="capacity" placeholder="Об'єм (л.)" autocomplete="off" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row errors">
                            <div class="col-sm-5 col-sm-offset-7"><label for="power" style="color:red;text-align:left;" class="control-label"><form:errors path="power"/></label></div>
                        </div>
                        <label for="transmission" class="col-sm-1 control-label">Коробка</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="transmission" id="transmission">
                                <form:option value="0" label="Трансмісія" disabled="true" selected="true"/>
                                <form:options items="${transmissions}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>

                        <label for="power" class="col-sm-1 control-label" style="padding-left: 0">Потужність</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="power" id="power" placeholder="Потужність (kWt)" autocomplete="off" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="drive" class="col-sm-1 control-label">Привід</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="drive" id="fuelType">
                                <form:option value="0" label="Привід" disabled="true"  selected="true" />
                                <form:options items="${drives}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>
                        <label for="bodyType" class="col-sm-1 control-label">Кузов</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="bodyType" id="fuelType">
                                <form:option value="0" label="Тип кузова" disabled="true"  selected="true" />
                                <form:options items="${bodyTypes}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row errors" style="margin: auto 5px;">
                            <div class="col-sm-5 col-sm-offset-1"><label for="doorsCount" style="color:red;text-align:left;" class="control-label"><form:errors path="doorsCount"/></label></div>
                            <div class="col-sm-5 col-sm-offset-1"><label for="seatsCount" style="color:red;text-align:left;" class="control-label"><form:errors path="seatsCount"/></label></div>
                        </div>

                        <label for="doorsCount" class="col-sm-1 control-label">Двері</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="doorsCount" id="doorsCount" placeholder="Кількість дверей" autocomplete="off" />
                        </div>

                        <label for="seatsCount" class="col-sm-1 control-label">Місця</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="seatsCount" id="seatsCount" placeholder="Кількість місць" autocomplete="off" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="color" class="col-sm-1 control-label">Колір</label>
                        <div class="col-sm-5">
                            <form:select class="form-control" path="color" id="color">
                                <form:option value="0" label="Колір" disabled="true"  selected="true" />
                                <form:options items="${colors}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group options">
                        <div class="col-sm-12">
                            <h4>Опції</h4>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasAbs"/> ABS
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasEsp"/> ESP
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasAirbag"/> Airbag
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasConditioner"/> Кондиціонер
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasClimateControl"/> Клімат
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasHeatedSeats"/> Підігрів сидінь
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasHeatedMirrors"/> Підігрів дзеркал
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasHeatedSteeringWheel"/> Підігрів руля
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasLeather"/> Шкіра
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasHatch"/> Люк
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasParktronic"/> Парктронік
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasGlassHoist"/> Склопідйомники
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasElectricMirrors"/> Ел. дзеркала
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasElectricSeats"/> Ел. сидіння
                            </label>
                            <label class="checkbox-inline">
                                <form:checkbox path="hasDamaged"/> Пошкодження
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row errors">
                            <div class="col-sm-11 col-sm-offset-1"><label for="name" style="color:red;text-align:left;" class="control-label"><form:errors path="name"/></label></div>
                        </div>

                        <label for="name" class="col-sm-1 control-label">Назва</label>
                        <div class="col-sm-5"  id="nameInput">
                            <form:input class="form-control" path="name" id="name" placeholder="Назва" autocomplete="off" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row errors">
                            <div class="col-sm-5 col-sm-offset-1"><label for="price" style="color:red;text-align:left;" class="control-label"><form:errors path="price"/></label></div><div class="col-sm-11 col-sm-offset-1"><label for="name" style="color:red;text-align:left;" class="control-label"><form:errors path="name"/></label></div>
                        </div>

                        <label for="price" class="col-sm-1 control-label">Ціна</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="price" id="price" placeholder="Ціна" autocomplete="off" />
                        </div>
                        <label for="fullPrice" class="col-sm-1 control-label">Повна</label>
                        <div class="col-sm-5">
                            <form:input type="text" class="form-control" path="fullPrice" placeholder="Ціна з митом" autocomplete="off" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-1 control-label">Опис</label>
                        <div class="col-sm-11">
                            <form:textarea type="text" class="form-control" path="description" rows="3" placeholder="Опис" autocomplete="off" maxlength="510"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="images" class="col-sm-1 control-label">Фото</label>
                        <div class="col-sm-12">
                            <form:input type="file" path="images" placeholder="Назва" accept="image/jpeg,image/png" multiple="multiple"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <button type="submit" class="btn btn-primary">Створити</button>
                            <form:button type="reset" class="btn btn-primary">Скинути</form:button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row" style="vertical-align: middle">
            <div class="col-md-3 col-xs-3"><h4>Фото</h4></div>
            <div class="col-md-5 col-xs-3"><h4>Назва</h4></div>
            <div class="col-md-2 col-xs-3"><h4>Оновити</h4></div>
            <div class="col-md-2 col-xs-3"><h4>Видалити</h4></div>
        </div>
        <c:forEach items="${page.content}" var="commodity">
            <div class="accordion row">
                <div class="col-md-3 col-xs-3">
                    <img src="/images/auto_${(commodity.id+1)*33}/${commodity.model.make.name}_${commodity.model.name}_${commodity.year}_${String.format("%.2f", commodity.capacity).replace(",", ".")}_0.jpg?version=${commodity.version}" alt="Натисніть два рази на фото, яке має бути головним" class="img-responsivee">
                </div>
                <div class="col-md-5 col-xs-3">${commodity.name}</div>
                <div class="col-md-2 col-xs-3"><a class="btn btn-warning" href="/admin/commodity/update/${commodity.id}">&#x21ba;</a></div>
                <div class="col-md-2 col-xs-3"><a class="btn btn-danger" href="/admin/commodity/delete/${commodity.id}">&#10006;</a></div>
            </div>
            <div class="accordion__inner">
                <div class="images row">
                    <c:forEach var="i" begin="${commodity.isSetMainImage ? 0 : 1}" end="${ commodity.isSetMainImage ? commodity.imagesCount - 1 : commodity.imagesCount }">
                        <div class="col-xs-4 col-md-3">
                            <img src="/images/auto_${(commodity.id+1)*33}/${commodity.model.make.name}_${commodity.model.name}_${commodity.year}_${String.format("%.2f", commodity.capacity).replace(",", ".")}_${i}.jpg?version=${commodity.version}" alt="${commodity.name} ${commodity.year}" class="img-responsivee commodity-images">
                        </div>
                    </c:forEach>

                </div>
                <div class="description row">
                    <div class="col-xs-12">
                    <div class="row">
                        <div class="col-xs-4">Топливо: </div>
                        <div class="col-xs-8">${ commodity.fuelType.name}</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Об'єм: </div>
                        <div class="col-xs-8">${ commodity.capacity } л</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Пробіг: </div>
                        <div class="col-xs-8">${ commodity.kilometrage } тис. км</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Коробка: </div>
                        <div class="col-xs-8">${ commodity.transmission.name }</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Тип кузова: </div>
                        <div class="col-xs-8">${ commodity.bodyType.name }</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Привід:</div>
                        <div class="col-xs-8">${ commodity.drive.name }</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Колір: </div>
                        <div class="col-xs-8">${ commodity.color.name }</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Потужність: </div>
                        <div class="col-xs-8">${ commodity.power } кВт</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Двері: </div>
                        <div class="col-xs-8">${ commodity.doorsCount }</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Місця: </div>
                        <div class="col-xs-8">${ commodity.seatsCount }</div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">Ціна</div>
                        <div class="col-xs-8">${ commodity.price } &#x20ac;</div>
                        <div class="col-xs-4">З митом</div>
                        <div class="col-xs-8">${ commodity.fullPrice } &#x20ac;</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">Опис</div>
                        <div class="col-xs-8">${ commodity.description }</div>
                    </div>
                    </div>
                    <div class="col-xs-12"></div>

                </div>
            </div>
        </c:forEach>
    </div>
    <div class="col-md-1">
        <div class="col-md-6 col-xs-4 col-xs-offset-2 text-center">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button"
                        data-toggle="dropdown">
                    Сортування <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <custom:sort innerHtml="Ім'я за зростанням" paramValue="name" />
                    <custom:sort innerHtml="Ім'я за спаданням" paramValue="name,desc" />
                    <custom:sort innerHtml="Модель за зростанням" paramValue="model.name" />
                    <custom:sort innerHtml="Модель за спаданням" paramValue="model.name,desc" />
                    <custom:sort innerHtml="Ціна за зростанням" paramValue="price" />
                    <custom:sort innerHtml="Ціна за спаданням" paramValue="price,desc" />
                </ul>
            </div>
        </div>
        <div class="col-md-6 col-xs-4 col-xs-offset-2 text-center">
            <custom:size posibleSizes="10,20,40,80" size="${page.size}" />
        </div>
    </div>

    <script>
        $(".images").children().dblclick(function () {
            var self = $(this),
                    html = self.html(),
                    number = html.substr(html.indexOf('.jpg')-2),
                    comId = html.substr(html.indexOf('auto_') + 5);
            console.log(number);
            console.log(comId);

            number.search("_") == "-1" ? number = number.substring(0, number.indexOf(".jpg"))
                    : number = number.substring(1, number.indexOf(".jpg"));
            console.log(number);
            comId = comId.substr(0, comId.indexOf("/"));
            console.log(comId/33-1);
            self.css("border", "1px solid #337ab7");
            $.ajax({
                type: 'GET',
                contentType: "text/html; charset=UTF-8",
                url: "commodity/setMainPhoto/" + (comId/33-1) + '_' + number,
                success : function(data) {
                    location.reload();
                }
            })
        });
        $(".size-button").addClass("btn btn-secondary");
    </script>
    <script>
        $("#make").change(function () {
            $.ajax({
                type: 'GET',
                contentType: "text/html; charset=UTF-8",
                url: "/getModels/" + $("#make").val(),
                success : function(data) {
                    $("#model").empty().append(data);
                }
            })
        });

        var elements = document.getElementsByClassName("errors");
    for(var i = 0; i < elements.length; i++) {
        if (!elements[i].firstElementChild.firstElementChild.innerHTML || !elements[i].lastElementChild.firstElementChild.innerHTML) {
            elements[i].style.display = "none";
        }
    }
    var optionLabels = document.querySelectorAll("option:disabled");
    for (i = 0; i < optionLabels.length; i++) {
        optionLabels[i].parentElement.style.color = "#999";
        optionLabels[i].parentElement.addEventListener("change", function () {
            this.style.color = "#555";
            this.children[0].defaultSelected = false;
        });
    }
    var nameInput = $("#name");
    nameInput.focusin(function () {
        nameInput.width("91.66%");
        nameInput.queue(function () {
            nameInput.parent().removeClass("col-sm-5");
            nameInput.parent().addClass("col-sm-11");
            nameInput.dequeue();
        });
        nameInput.width("");
    });
    nameInput.focusout(function () {
        nameInput.width("41.66%");
        nameInput.queue(function () {
            nameInput.parent().removeClass("col-sm-11");
            nameInput.parent().addClass("col-sm-5");
            nameInput.dequeue();
        });
        nameInput.width("");
    });
    $('.search-container').slideUp(500, "swing");
    $('.search').click(function () {
        var self = $(this),
            container = $('.search-container');

        if (!container.hasClass('expanded')) {
            container.stop(true, true).slideDown(500, "swing", function () {
                self.removeClass('icon-angle-down');
                self.addClass('icon-angle-up');
            });
            container.addClass('expanded');
        } else {
            container.stop(true, true).slideUp(500, "swing", function () {
                self.removeClass('icon-angle-up');
                self.addClass('icon-angle-down');
            });
            container.removeClass('expanded');
        }
    });

        $(document).ready(function () {
            $(".accordion").click(function () {
                var     self = $(this),
                        content = self.next(),
                        duration = 500;

                if (!self.hasClass("active_")) {
                    self.addClass("active_");
                    content.stop(true).slideDown(duration);
                } else {
                    content.stop(true).slideUp(duration);
                    self.removeClass("active_");
                }
            });
        });
    </script>
</div>
    <div class="row">
        <div class="col-xs-12 text-center">
            <custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
        </div>
    </div>
</div>
<style>
    .pagination>.active>a,.pagination>.active>a:focus,.pagination>.active>a:hover,.pagination>.active>span,.pagination>.active>span:focus,.pagination>.active>span:hover{background-color:#c00;border-color:#353133}.pagination>li>a:focus,.pagination>li>a:hover,.pagination>li>span:focus,.pagination>li>span:hover{color:#c00}.pagination>li>a,.pagination>li>span{font-family:zlatatrans;color:#353133}
    .options h4 {
        margin-left: -4.8%;
    }
    .options {
        padding-left: 5%;
        padding-right: 5%;
        padding-bottom: 1%;
    }
    .options label {
        font-size: 16px;
        margin-right: 20px;
    }
    .options label:first-of-type {
        margin-left: 10px;
    }
    .form-horizontal .control-label {
        text-align: left;
    }
    #nameInput {
        transition: all 1s;
        -o-transition: all 1s;
        -moz-transition: all 1s;
        -webkit-transition: all 1s;
    }
    .search {
        position: relative;
        cursor: pointer;
    }
    .img-responsivee {
        width: 98%;
        height: auto;
        cursor: pointer;
    }
    .images {
    	padding-top: 10px;
    }
    .dropdown-menu {
        right: 0;
        left:auto;
    }
    .commodity-images {
        margin: 5px 0;
    }
    div.accordion {cursor: pointer;} div.accordion div {cursor: pointer;} .accordion__inner {display:none; position: relative;  padding-bottom: 15px;} .description { margin:15px; border-top: 1px solid #ccc;border-bottom: 1px solid #ccc;}
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