<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<sec:authorize access="isAuthenticated()">
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-2">
			<a href="/logout">Вийти</a>
		<%--<form:form action="/logout" method="post">--%>
			<%--<button type="submit">Вийти</button>--%>
		<%--</form:form>--%>
		</div>
	</div>
</div>
</sec:authorize>