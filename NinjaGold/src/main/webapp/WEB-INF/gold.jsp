<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/gold.css">
<title>Ninja Gold</title>
</head>
<body>
	    <div id="container">
        <h2>Ninja Gold</h2>
        <br>
        <p>Your Gold: <c:out value="${gold}"/></p>
        <div id="gold-box">
            <form class="ninja" action="/process-money" method="POST">
                <h4>Farm</h4>
                <p>(earns 10-20 golds)</p>
                <input type="hidden" name="candy" value="farm">
                <input class="button" type="submit" value="Find Gold!">
            </form>
            <form class="ninja" action="/process-money" method="POST">
                <h4>Cave</h4>
                <p>(earns 5-10 golds)</p>
                <input type="hidden" name="candy" value="cave">
                <input class="button" type="submit" value="Find Gold!">
            </form>
            <form class="ninja" action="/process-money" method="POST">
                <h4>House</h4>
                <p>(earns 2-5 golds)</p>
                <input type="hidden" name="candy" value="house">
                <input class="button" type="submit" value="Find Gold!">
            </form>
            <form class="ninja" action="/process-money" method="POST">
                <h4>Casino</h4>
                <p>(earns/takes 0-50 golds)</p>
                <input type="hidden" name="candy" value="casino">
                <input class="button" type="submit" value="Find Gold!">
            </form>
        </div>
        <h3>Activites</h3>
        <div class="log-info">
    		<% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("log");%>
    		<% Collections.reverse(activities); %>
    		<% for(String activity : activities) {%>
    		<p><%= activity %></p>
    		<% }%>
        </div>
        <form action="/reset">
            <input type="submit" name="reset" class="button" value="Reset">
        </form>
    </div>
</body>
</html>