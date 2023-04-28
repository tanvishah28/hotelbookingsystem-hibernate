<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Customers of a Hotel</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<!-- creating table -->
	<div class="container">
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-dark">
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Email ID</th>
				<th>Preferences</th>
				<th>Special Needs</th>
			</tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.customer_id}</td>
					<td>${customer.customer_name}</td>
					<td>${customer.customer_address}</td>
					<td>${customer.customer_phone}</td>
					<td>${customer.customer_email}</td>
					<td>${customer.preferences}</td>
					<td>${customer.special_needs}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>