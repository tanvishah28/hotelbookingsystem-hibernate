<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Hotels</title>
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
				<th>Location</th>
				<th>Phone</th>
				<th>Email ID</th>
				<th>Rating</th>
				<th>Pet Friendly</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${hotelList}" var="hotel">
				<tr>
					<td>${hotel.hotel_id}</td>
					<td>${hotel.hotel_name}</td>
					<td>${hotel.hotel_location}</td>
					<td>${hotel.hotel_phone}</td>
					<td>${hotel.hotel_email}</td>
					<td>${hotel.hotel_rating}</td>
					<td>${hotel.pet_friendly}</td>
					<td><a
						href="/hotelbookingsystem/hotels/${hotel.hotel_id}/editHotelForm">Edit</a>
					</td>
					<td><a
						onClick="deleteHotel('/hotelbookingsystem/hotels/${hotel.hotel_id}')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="/hotelbookingsystem/resources/js/http.js">
		
	</script>
	<script src="/hotelbookingsystem/resources/js/app.js">
		
	</script>
</body>
</html>