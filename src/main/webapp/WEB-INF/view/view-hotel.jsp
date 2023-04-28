<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View a Hotel</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<h3>This page will get a single hotel</h3>
	<div class="container">
		<h3>Hotel Info:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Hotel ID</th>
				<td>${hotel.hotel_id}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Hotel Name</th>
				<td>${hotel.hotel_name}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Hotel Location</th>
				<td>${hotel.hotel_location}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Hotel Phone</th>
				<td>${hotel.hotel_phone}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Hotel Rating</th>
				<td>${hotel.hotel_rating}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Hotel Email</th>
				<td>${hotel.hotel_email}</td>
			</tr>
			<tr class="thead-light">
				<th style="width: 20%">Pet Friendly</th>
				<td>${hotel.pet_friendly}</td>
			</tr>
		</table>

		<h3>Customers:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Customers</th>
				<c:forEach items="${hotel.customers}" var="hotelCustomer">
					<td>${hotelCustomer.customer.customer_id}</td>
				</c:forEach>
			</tr>
		</table>

		<h3>Rooms of hotel:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Rooms</th>
				<c:forEach items="${hotel.rooms}" var="room">
					<td>${room.room_id}</td>
				</c:forEach>
			</tr>
		</table>
		
		<h3>Employees of hotel:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Employees</th>
				<c:forEach items="${hotel.employees}" var="emp">
					<td>${emp.emp_id}</td>
				</c:forEach>
			</tr>
		</table>

		<h3>Services:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Services</th>
				<c:forEach items="${hotel.services}" var="hotelService">
					<td>${hotelService.service.service_id}</td>
				</c:forEach>
			</tr>
		</table>

		<h3>Bookings of a hotel:</h3>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-light">
				<th style="width: 20%">Bookings</th>
				<c:forEach items="${hotel.bookings}" var="booking">
					<td>${booking.booking_id}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>