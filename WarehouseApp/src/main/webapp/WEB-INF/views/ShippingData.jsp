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

  <a href="pdf">PDF FILE</a>
        <a href="excel">EXCEL FILE</a>
	     <h3>welcome to Data Page</h3>

	<table border="1">

		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>SHIPPING REF NO</th>
			<th>COURIER REF NO</th>

			<th colspan="3">OPERATION</th>
		</tr>

		<c:forEach items="${list}" var="ob">
			<tr>

				<td><c:out value="${ob.id}" /></td>
				<td><c:out value="${ob.shippingCode}" /></td>
				<td><c:out value="${ob.refNo}" /></td>
				<td><c:out value="${ob.crefNo}" /></td>

				<td><a href="delete?id=${ob.id}">DELETE</a></td>
				<td><a href="edit?id=${ob.id}">EDIT</a></td>
				<td><a href="view?id=${ob.id}">VIEW</a></td>
			</tr>

		</c:forEach>
	</table>
	${msg}
  

</body>
</html>