<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<a href = "/questions">Back to Dashboard</a>
		<form action = "/questions/new" method = "post">
			<p>
				<c:out value = "${question}"/><br>
				Question: <br><br>
				<textarea name = "question" cols = "50" rows = "4"></textarea>
			</p>
			<p>
				<c:out value = "${tag}"/><br>
				Tags: <input type = "text" name = "tags">
			</p>
			<input type = "submit" value = "Add Question"/>
		</form>
</body>
</html>