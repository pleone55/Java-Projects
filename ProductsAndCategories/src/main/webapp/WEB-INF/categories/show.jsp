<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> <c:out value="${category.getName()}"/></title>
</head>
<body>
	<h1><c:out value="${category.getName()}"/></h1>
	<br>
	<br>
	<ul>
		<c:forEach items="${category.getProducts()}" var="product">
			<li><c:out value="${product.getName()}" /></li>								
		</c:forEach>
	</ul>
	<form action="/categories/<c:out value="${category.getId()}"/>" method="post">
		<input type="hidden" name="_method" value="put">
			<label for="category">Add Product:</label>
			<select name="id">
				<c:forEach items="${products}" var="product">
					<option value="${product.getId()}" label="${product.getName()}" />
				</c:forEach>										
			</select>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>