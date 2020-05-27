<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserType View Page</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
<div class="container">
	<div class="card">
		<div class="card-header">
			<h4>Welcome To WhUser View More Page</h4>
		</div>
		<div class="card-body">
			<table class="table table-bordered table-hover table-condensed">
				<tr>
					<th>ID</th>
					<td>${ob.id }</td>
				</tr>
					<tr>
					<th>USER TYPE</th>
					<td>${ob.userType }</td>
				</tr>
					<tr>
					<th>USER CODE</th>
					<td>${ob.userCode }</td>
				</tr>
					<tr>
					<th>USER FOR</th>
					<td>${ob.userFor }</td>
				</tr>
					<tr>
					<th>EMAIL</th>
					<td>${ob.userEmail }</td>
				</tr>
					<tr>
					<th>MOBILE NUMBER</th>
					<td>${ob.mobileNumber }</td>
				</tr>
				<tr>
					<th>ID TYPE</th>
					<td>${ob.idType }</td>
				</tr>
				<tr>
					<th>OTHER ID</th>
					<td>${ob.othersId }</td>
				</tr>
				<tr>
					<th>ID NUMBER</th>
					<td>${ob.idNumber }</td>
				</tr>
				<tr>
					<td>
						<a href="excel?id=${ob.id}" class="btn btn-success">Excel view</a>
						<a href="pdf?id=${ob.id}" class="btn btn-success">PDF view</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="card-footer bg-dark text-white text-center" >
			<h6>All Copy Rights Reserved maintained by sandeep KuMar</h6>
		</div>
	</div>
</div>

</body>
</html>