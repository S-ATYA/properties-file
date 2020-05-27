<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <table border="1">
    
    <tr>
       <th>ID</th>
       <td>${ob.id}</td>
    </tr>
    
    
    <tr>
       <th>CODE</th>
       <td>${ob.grnCode}</td>
    </tr>
    
     <tr>
       <th>TYPE</th>
       <td>${ob.grnType}</td>
    </tr>
    
     <tr>
       <th>OD CODE</th>
       <td>${ob.grnOCode}</td>
    </tr>
    
     <tr>
       <th>DESCRIPTION</th>
       <td>${ob.description}</td>
    </tr>
    </table>
    <a href="excel?id=${ob.id}">Excel View</a>
     <a href="pdf?id=${ob.id}">pdf View</a>
</body>
</html>