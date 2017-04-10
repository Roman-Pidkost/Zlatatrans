<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<tiles:insertAttribute name="head" />
	<tiles:insertAttribute name="customHead" />
</head>
<body>
<div class="container-fluid">
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
</div>
</body>
</html>