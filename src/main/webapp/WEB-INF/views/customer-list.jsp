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

<title>Customer List</title>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center; color: maroon;">Customer
			Relationship Management</h2>
		<a href="/CustomerRelationshipManagement/showFormForAdd"
			class="btn btn-primary">Add Customer</a>
		<hr>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customers}" var="temp">
					<tr>
						<td><c:out value="${temp.firstName}" /></td>
						<td><c:out value="${temp.lastName}" /></td>
						<td><c:out value="${temp.email}" /></td>
						<td><a
							href="/CustomerRelationshipManagement/showFormForUpdate?customerId=${temp.id}"
							class="btn btn-info btn-sm">Update</a> <a
							href="/CustomerRelationshipManagement/delete?customerId=${temp.id}"
							class="btn btn-danger btn-sm"
							onclick="if(!(confirm('Are you sure you want to delete this customer record?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>