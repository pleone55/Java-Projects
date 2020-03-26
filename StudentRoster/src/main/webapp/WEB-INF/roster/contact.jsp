<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Contact</title>
</head>
<body>
	<h1>New Contact</h1>
	<br>
	<form:form action="/contact/new" method="post" modelAttribute="contact">
		<form:label path="student">Student:</form:label>
			<form:select path="student">
				<c:forEach items="${students}" var="persons">
					<form:option value="${persons}" label="${persons.getFirstName()} ${persons.getLastName()}"/>
				</c:forEach>
			</form:select>
			<form:errors path="student"/>
		<p>
			<form:label path="address">Address:</form:label>
			<form:errors path="address"/>
			<form:input path="address"/>
		</p>
		<p>
			<form:label path="city">City:</form:label>
			<form:errors path="city"/>
			<form:input path="city"/>
		</p>
		<p>
			<form:label path="state">State:</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<input type="submit" value="Create"/>		
	</form:form>
</body>
</html>