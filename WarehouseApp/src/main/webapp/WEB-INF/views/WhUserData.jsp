<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserType Data page</title>
</head>
<body>
	<%@include file="usermenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h4>Welcome To WhUser Data Page</h4>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover table-condensed">
					<tr class="table-primary">
						<th>ID</th>
						<th>CODE</th>
						<th>OPERATIONS</th>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td><c:out value="${ob.id}" /></td>
							<td><c:out value="${ob.userCode }" /></td>
							<td><a href="delete?id=${ob.id}" class="btn btn-danger">DELETE</a>
								<a href="edit?id=${ob.id}" class="btn btn-warning">EDIT</a> <a
								href="view?id=${ob.id}" class="btn btn-primary">VIEW MORE</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td>
							<a href="excel" class="btn btn-success">EXCEL EXPORT</a>
							<a href="pdf" class="btn btn-success">PDF EXPORT</a>
						</td>
					</tr>
				</table>
			</div>
			<div class="card-footer bg-dark text-white text-center">${msg}
			</div>
		</div>
	</div>


</body>
</html>