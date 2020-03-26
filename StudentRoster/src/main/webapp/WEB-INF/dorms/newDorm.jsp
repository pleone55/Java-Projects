<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dorm</title>
</head>
<body>
	<h1>Dormitories</h1>
	<br>
	<form:form action="/dorms/new" method="post" modelAttribute="dorms">
	<p>
		<form:label path="dormName">Name</form:label>
		<form:errors path="dormName"/>
		<form:input path="dormName"/>
	</p>
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>