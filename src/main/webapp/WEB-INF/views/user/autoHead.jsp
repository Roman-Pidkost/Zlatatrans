<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>${auto.model.make.name} ${auto.model.name} ${auto.capacity} ${auto.fuelType.name} ${auto.year} авто з Європи - Zlatatrans</title>
<meta name="description" content="Нерозмитнений автомобіль ${auto.name} ${auto.year} за вигідною ціною">
<meta name="keywords" content="${auto.model.make.name} ${auto.model.name} ${auto.capacity} ${auto.fuelType.name} ${auto.year}">
<meta property="og:title" content="${auto.model.make.name} ${auto.model.name} ${auto.capacity} ${auto.fuelType.name} ${auto.year} авто з Європи - Zlatatrans">
<meta property="og:description" content="Нерозмитнений автомобіль ${auto.name} ${auto.year}. Zlatatrans - автомобілі за кордоном, в Європі.">
<meta property="og:url" content="http://zlatatrans.com.ua/auto/${auto.model.make.name}-${auto.model.name}-${auto.year}-${String.format("%.2f", auto.capacity).replace(",", ".")}/${auto.id}">
<meta property="og:image" content="/images/auto_${(auto.id+1)*33}/${auto.model.make.name}_${auto.model.name}_${auto.year}_${String.format("%.2f", auto.capacity).replace(",", ".")}_<c:choose><c:when test='${auto.isSetMainImage}'>0</c:when><c:otherwise>1</c:otherwise></c:choose>.jpg?version=${auto.version}">
<script id="pagecss">loadCSS("/resources/css/commodity.min.css", document.getElementById("pagecss"));</script>