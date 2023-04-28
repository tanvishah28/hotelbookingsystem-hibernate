<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Hotel</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<div class="container">

		<form:form action="/hotelbookingsystem/hotels/${hotel.hotel_id}"
			method="DELETE" modelAttribute="hotel">
		
		Hotel ID : <form:input path="hotel_id" />
		
		<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>