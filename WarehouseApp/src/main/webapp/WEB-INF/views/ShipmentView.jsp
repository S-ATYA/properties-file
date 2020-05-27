<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center ">
				<h3>Welcome To Shipment View Page</h3>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover table-condensed">
					<tr>
						<th>ID</th>
						<td>${ob.id}</td>
					</tr>
					<tr>
						<th>TYPE</th>
						<td>${ob.shipmentType}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${ob.shipmentCode}</td>
					</tr>
					<tr>
						<th>ENABLE</th>
						<td>${ob.shipmentEnable}</td>
					</tr>
					<tr>
						<th>GRADE</th>
						<td>${ob.shipmentGrade}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${ob.description}</td>
					</tr>
				</table>
				<a href="excel?id=${ob.id }" class="btn btn-success">View Excel </a>
				<a href="pdf?id=${ob.id }" class="btn btn-success">View PDF </a>
			</div>
			<div class="card-footer bg-dark text-center text-white">
				<h5>All Copy Rights Reserved maintained by Sandeep KuMar</h5>
			</div>
		</div>
	</div>
</body>
</html>