<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Form</title>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center; color: maroon;">Customer
			Relationship Management</h2>
		<br>

		<h3>Save Customer</h3>
		<hr>
		<form action="/CustomerRelationshipManagement/save" method="POST">
			<input type="hidden" name="id" value="${Customer.id}" />
			<div class="form-inline">
				<input type="text" name="firstName" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name" />
			</div>
			<div class="form-inline">
				<input type="text" name="lastName" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name" />
			</div>
			<div class="form-inline">
				<input type="email" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email" />
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		<hr>
		<a href="/CustomerRelationshipManagement/list">Back to List</a>
	</div>
</body>
</html>