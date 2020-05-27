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
<a href="pdf"><img src="../resources/images/BulkPdf.png" height="55" width="55"></a>
<a href="excel"><img src="../resources/images/BulkExcel.png" height="48" width="55"></a>
	<h3>WELCOME TO DATA PAGE</h3>

	<table border="1">

		<tr>
			<th>ID</th>
			<th>TYPE</th>
			<th>MODEL</th>

			<th colspan="3">OPERATION</th>
		</tr>

		<c:forEach items="${list}" var="ob">
			<tr>

				<td><c:out value="${ob.id}" /></td>
				<td><c:out value="${ob.uomType}" /></td>
				<td><c:out value="${ob.uomModel}" /></td>

				<td><a href="delete?id=${ob.id}"><img src="../resources/images/delete.png" height="25" width="25"></a></td>
				<td><a href="edit?id=${ob.id}"><img src="../resources/images/edit.png" height="25" width="25"></a></td>
				<td><a href="view?id=${ob.id}"><img src="../resources/images/view.png" height="25" width="25"></a></td>
			</tr>

		</c:forEach>
	</table>
	${msg}
</body>
</html>