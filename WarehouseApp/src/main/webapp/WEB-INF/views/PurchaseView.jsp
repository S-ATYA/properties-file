<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h5>Welcome To Purchase Data View</h5>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover table-condensed">
					<tr>
						<th>ID</th>
						<td>${ob.id}</td>
					</tr>
					<tr>
						<th>Order Code</th>
						<td>${ob.orderCode }</td>
					</tr>
					<tr>
						<th>SHIPMENT CODE</th>
						<td>${ob.shipmentCode.shipmentCode}</td>
					</tr>
					<tr>
						<th>VENDOR</th>
						<td>${ob.whUser.userCode}</td>
					</tr>
					<tr>
						<th>STATUS</th>
						<td>${ob.defaultStatus}</td>
					</tr>
					<tr>
						<th>REFERENCE NUMBER</th>
						<td>${ob.referenceNumebr}</td>
					</tr>
					<tr>
						<th>QUALITY CHECK</th>
						<td>${ob.qualityCheck}</td>
					</tr>
					<tr>
						<th>DESCRIPTION</th>
						<td>${ob.description}</td>
					</tr>
				</table>
				<a href="excel?id=${ob.id }" class="btn btn-success">View Excel</a>
				<a href="pdf?id=${ob.id }" class="btn btn-success">View PDF</a>
			</div>
			<div class="card-footer bg-dark text-white text-center">
				<h6>All copy rights reserved maintained by sj</h6>
			</div>
		</div>
	</div>
</body>
</html>