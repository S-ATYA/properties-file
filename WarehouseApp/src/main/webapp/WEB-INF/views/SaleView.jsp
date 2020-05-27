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
       <td>${ob.orderCode}</td>
    </tr>
    
     <tr>
       <th>MODE</th>
       <td>${ob.shipmentMode}</td>
    </tr>
    
    <tr>
       <th>CUSTOMER</th>
       <td>${ob.customer}</td>
    </tr>
    
    <tr>
       <th>REF NO</th>
       <td>${ob.referenceNo}</td>
    </tr>
    
    <tr>
       <th> STOCK MODE</th>
       <td>${ob. stockMode}</td>
    </tr>
    
    <tr>
       <th>STOCK SOURCE</th>
       <td>${ob.stockSource}</td>
    </tr>
    
     <tr>
       <th>NOTE</th>
       <td>${ob.description}</td>
    </tr>
    </table>
    <a href="excel?id=${ob.id}">Excel View</a>
     <a href="pdf?id=${ob.id}">pdf View</a>

</body>
</html>