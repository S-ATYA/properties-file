<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Data Page</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h5>Welcome To Purchase Data Page</h5>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover ">
					<tr class="table-primary">
						<th>ID</th>
						<th>CODE</th>
						<th>WhUSERTYPE CODE</th>
						<th>OPERATION</th>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td><c:out value="${ob.id}" /></td>
							<td><c:out value="${ob.orderCode }" /></td>
							<td><c:out value="${ob.whUser.userCode}" /></td>
							<td>
								<a href="delete?id=${ob.id} " class="btn btn-danger">Delete</a>
								<a href="edit?id=${ob.id}" class="btn btn-warning">Edit</a> 
								<a href="view?id=${ob.id}" class="btn btn-success">View</a>
								<a href="part?id=${ob.id}" class="btn btn-success">part</a>
							</td>
						</tr>
					</c:forEach>
						<tr>
							<td>
								<a href="excel" class="btn btn-success">Excel Export</a>
								<a href="pdf" class="btn btn-success">PDF Export</a>
							</td>
						</tr>
				</table>
			</div>
			<div class="card-footer bg-dark text-white text-center">
				${msg}
			</div>
		</div>
	</div>

</body>
</html>