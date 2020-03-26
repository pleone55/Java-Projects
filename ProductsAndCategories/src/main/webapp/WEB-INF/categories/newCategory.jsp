<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<form:form action="/categories/new" method="post" modelAttribute="category">
		<p>
			<form:label path="name">Name:</form:label> 
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<input type="submit" value="Submit" class="btn btn-success"/>
	</form:form>
</body>
</html>