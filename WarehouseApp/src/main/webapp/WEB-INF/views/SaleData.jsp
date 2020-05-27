<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
   <h3>WELCOME TO SALE DATA PAGE</h3>
   <a href="excel">EXCEL FILE</a>
    <a href="pdf">PDF FILE</a>
   <table border="1">
     
     
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>MODE</th>
            <th>REF NO</th>
			<th colspan="3">OPERATION</th>
			
		</tr>
		
		<c:forEach items="${sale}" var="ob">
		
		
		<tr>
			<td><c:out value="${ob.id}"/></td>
			<td><c:out value="${ob.orderCode}"/></td>
			<td><c:out value="${ob.customer}"/></td>
            <td><c:out value="${ob.referenceNo}"/></td>
			<td><a href="delete?id=${ob.id}">DELETE</a></td>
			<td><a href="edit?id=${ob.id}">EDIT</a></td>
			<td><a href="view?id=${ob.id}">VIEW</a></td>
		</tr>
		
		</c:forEach>
   
   
   </table>
   ${message}
</body>
</html>