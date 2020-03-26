<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
		<h2>All Students</h2>
		<h3><a href="/contact/new">Create Contact</a> | <a href="/students/new">Create Student</a></h3>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ students }" var="student">
				<tr>
					<td>${ student.firstName } ${ student.lastName }</td>
					<td>${ student.age }</td>
					<td>${ student.contact.address }</td>
					<td>${ student.contact.city }</td>
					<td>${ student.contact.state }</td>		
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>