<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Employees of a Hotel</title>
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
				<th>Salary</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Email ID</th>
				<th>Joining Date</th>
			</tr>
			<c:forEach items="${employeeList}" var="employee">
				<tr>
					<td>${employee.emp_id}</td>
					<td>${employee.emp_name}</td>
					<td>${employee.emp_salary}</td>
					<td>${employee.emp_phone}</td>
					<td>${employee.emp_address}</td>
					<td>${employee.emp_email}</td>
					<td>${employee.joining_date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>