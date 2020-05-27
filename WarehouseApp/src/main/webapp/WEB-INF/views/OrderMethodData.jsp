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
<a href="pdf">SHOW PDF</a>
<h3>welcome to Data Page</h3>
  
   <table border="1">
   
      <tr>
      <th>ID</th>
       <th>MODE</th>
       <th>CODE</th>
        <th>TYPE</th>
       
        <th colspan="3">OPERATION</th>
      </tr>
      
      <c:forEach items="${list}" var="ob">
         <tr>
         
         <td><c:out value="${ob.id}"/></td>
         <td><c:out value="${ob.orderMode}"/></td>
         <td><c:out value="${ob.orderCode}"/></td>
         <td><c:out value="${ob.orderType}"/></td>
         
         <td><a href="delete?id=${ob.id}">DELETE</a></td>
         <td><a href="edit?id=${ob.id}">UPDATE</a></td>
          <td><a href="view?id=${ob.id}">VIEW</a></td>
         </tr>
      
      </c:forEach>
   </table>
   ${msg}
</body>
</html>
