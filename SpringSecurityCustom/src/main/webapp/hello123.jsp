<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="author" content="Dharmaraj Pawale">
	<meta name="copyright" content="Sterlite Technologies Ltd.">
	<meta name="creation_date" content="18-Aug-2020">
	<title>Hello123</title>
</head>
<body>
	<h2 align="right"><a href="logout">logout</a></h2> 
	Hello JSP: ${3+2 }
	<p>Your Message is ${message }
	<p> Using JSTL
	<c:out value="${message }"></c:out>
	<ol>
	<c:forEach var="city" items="${cities }">
		<li>${city} </li>
	</c:forEach>
	</ol>
</body>
</html>