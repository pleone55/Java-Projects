<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<h1><c:out value="${languages.name}"/></h1>
	<p>Description: <c:out value="${languages.creator}"/></p>
	<p>Language: <c:out value="${languages.currentVersion}"/></p>
	<a href="/languages/edit/${languages.id}">Edit</a>
	<a href="/languages/delete/${languages.id}">Delete</a>
</body>
</html>