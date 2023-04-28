<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Hotel</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<div class="container">

		<form action="/hotelbookingsystem/hotels" method="POST">
			Enter Hotel Name: <input type="text" name="hotel-name"
				value="${hotel.hotelName}" /><br /> 
			Enter Hotel Location: <input
				type="text" name="hotel-location" value="${hotel.hotelLocation}" /><br />
			Enter Hotel Phone: <input type="text" name="hotel-phone"
				value="${hotel.hotelPhone}" /><br /> 
			Enter Hotel Email: <input
				type="text" name="hotel-email" value="${hotel.hotelEmail}" /><br />
			Enter Hotel Rating: <input type="text" name="hotel-rating"
				value="${hotel.hotelRating}" /><br /> 
			Enter Pet Friendly: <input
				type="text" name="pet-friendly" value="${hotel.hotelPetFriendly}" /><br />
			<button class="btn btn-primary" type="submit">Add Hotel</button>
		</form>
	</div>
</body>
</html>