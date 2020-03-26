<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${product.getName()}"/></title>
</head>
<body>
	<h1><c:out value="${product.getName()}"/></h1>
	<br>
	<br>
	<ul>
		<c:forEach items="${product.getCategories()}" var="category">
			<li><c:out value="${category.getName()}" /></li>								
		</c:forEach>
	</ul>
	<form action="/products/<c:out value="${product.getId()}"/>" method="post">
		<input type="hidden" name="_method" value="put">
		<label for="category">Add Category:</label>
			<select name="id">
				<c:forEach items="${categories}" var="category">
					<option value="${category.getId()}" label="${category.getName()}" />
				</c:forEach>										
			</select>
		<input type="submit" value="Submit" class="btn btn-success"/>
	</form>
</body>
</html>