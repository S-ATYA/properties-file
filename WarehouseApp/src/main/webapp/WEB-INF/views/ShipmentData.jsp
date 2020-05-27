<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="card-header bg-primary text-white text-center">
				<h4>Welcome Shipment Data Page</h4>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover table-condensed">
					<tr class="table-primary">
						<th>ID</th>
						<th>Shipment TYPE</th>
						<th>Shipment Code</th>
						<th>Operation</th>
					</tr>
					<c:forEach items="${list }" var="ob">
						<tr>
							<td><c:out value="${ob.id}" /></td>
							<td><c:out value="${ob.shipmentType}" /></td>
							<td><c:out value="${ob.shipmentCode }" /></td>
							<td>
								<a href="delete?id=${ob.id }" data-toggle="tooltip" data-placement="bottom" title="Delete">
									<img  src="../resources/images/delete.png" height="25" width="25" />
								</a>
								<a href="edit?id=${ob.id }" data-toggle="tooltip" data-placement="bottom" title="Edit">
									<img  src="../resources/images/edit.png" height="25" width="25" />
								</a>
								<a href="view?id=${ob.id }" data-toggle="tooltip" data-placement="bottom" title="View More">
									<img  src="../resources/images/view2.png" height="25" width="25" />
							    </a>
							</td>						
						</tr>
					</c:forEach>
				</table>
				<a href="excel" >
					<img  src="../resources/images/BulkExcel.png" height="80" width="80" data-toggle="tooltip" data-placement="bottom" title="Bulk Export Excel "/>
				</a>
				<a href="pdf">
					<img  src="../resources/images/BulkPdf.png" height="80" width="80" data-toggle="tooltip" data-placement="bottom" title="Bulk Pdf Export"/>
				</a>
			</div>
			<div class="card-footer bg-dark text-white text-left">${msg}</div>
		</div>
	</div>
</body>
</html>