<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dorm List</title>
</head>
<body>
		<h2><c:out value="${dorms.getDormName()}"/> Dormitory</h2>
		<form:form action="/dorms/${dorms.id}" method="post" modelAttribute="dorms">
			<form:label path="student">Student:</form:label>
				<form:select path="student">
					<c:forEach items="${students}" var="persons">
						<form:option value="${persons.id}" label="${persons.getFirstName()} ${persons.getLastName()}"/>
					</c:forEach>
				</form:select>
			<form:errors path="student"/>
			<input type="submit" value="Add"/>
		</form:form>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ dorms.student }" var="student">
				<tr>
					<td><c:out value="${ student.firstName }"/> <c:out value="${ student.lastName }"/></td>
					<td><a href="/dorms/${student.id}/remove">Remove</a></td>	
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>