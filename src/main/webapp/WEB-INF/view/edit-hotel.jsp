<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a Hotel</title>
</head>
<body>
	<h1>This page will edit a single hotel</h1>

	<div class="container">
		<form
			onsubmit="editHotel(`/hotelbookingsystem/hotels/${hotel.hotel_id}`)"
			id="formId" name="form1">
			Hotel Name: <input type="text" name="hotel-name" id="name"
				value="${hotel.hotel_name}" /> <br /> 
			Hotel Location: <input id="location" type="text" name="hotel-location"
				value="${hotel.hotel_location}" /> <br /> 
			Hotel Phone: <input type="text" id="phone" name="hotel-phone"
				value="${hotel.hotel_phone}" /> <br /> 
			Hotel Email: <input type="text" name="hotel-email" id="email"
				value="${hotel.hotel_email}" /> <br /> 
			Hotel Rating: <input type="text" name="hotel-rating" id="rating"
				value="${hotel.hotel_rating}" /> <br /> 
			Pet Friendly: <input type="text" id="pet-friendly" name="pet-friendly"
				value="${hotel.pet_friendly}" /> <br />
			<!-- <button class="btn btn-primary" type="submit">Update Hotel</button> -->
			<input type="submit" value="Update Hotel" />
		</form>
	</div>

	<script src="/hotelbookingsystem/resources/js/http.js">
	</script>
	<script src="/hotelbookingsystem/resources/js/app.js">
	</script>

</body>
</html>