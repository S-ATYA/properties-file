<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <body>
      <table border="1">
    
    <tr>
       <th>ID</th>
       <td>${ob.id}</td>
    </tr>
    
    
    <tr>
       <th>MODE</th>
       <td>${ob.orderMode}</td>
    </tr>
    
     <tr>
       <th>CODE</th>
       <td>${ob.orderCode}</td>
    </tr>
    
     <tr>
       <th>TYPE</th>
       <td>${ob.orderType}</td>
    </tr>
    
    <tr>
       <th>DESCR</th>
       <td>${ob.description}</td>
    </tr>
    </table>
    <a href="excel?=${ob.id}">EXCEL VIEW</a>
      <a href="pdf?=${ob.id}">PDF VIEW</a>
</body>
</html>