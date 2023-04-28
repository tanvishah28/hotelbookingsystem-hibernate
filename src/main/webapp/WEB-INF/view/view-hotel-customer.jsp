<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View a Customer of a Hotel</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
<!-- 	<h3>This page will get a single customer of a hotel</h3> -->
	<div class="container">
		<h3>Customer Info:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Customer ID</th>
				<td>${customer.customer_id}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Customer Name</th>
				<td>${customer.customer_name}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Customer Address</th>
				<td>${customer.customer_address}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Customer Phone</th>
				<td>${customer.customer_phone}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Customer Email</th>
				<td>${customer.customer_email}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Customer Preferences</th>
				<td>${customer.preferences}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Customer Special Needs</th>
				<td>${customer.special_needs}</td>
			</tr>
		</table>

		<h3>Bookings done:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Customer Bookings</th>
				<c:forEach items="${customer.bookings}" var="booking">
					<td>${booking.booking_id}</td>
				</c:forEach>
			</tr>
		</table>

		<h3>Bills:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Customer Bills</th>
				<c:forEach items="${customer.bookings}" var="bill">
					<td>${bill.bill.bill_id}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>