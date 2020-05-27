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
       <td>${ob.shippingCode}</td>
    </tr>
    
     <tr>
       <th>SHIPPING REF NO</th>
       <td>${ob.refNo}</td>
    </tr>
    
     <tr>
       <th>COURIER REF NO</th>
       <td>${ob.refNo}</td>
    </tr>
    
     <tr>
       <th>CONTACT DETAILS</th>
       <td>${ob.cdetails}</td>
    </tr>
    
    <tr>
       <th>SALE ORDER CODE</th>
       <td>${ob.orderCode}</td>
    </tr>
    
     <tr>
       <th>DESCRIPTION</th>
       <td>${ob.description}</td>
    </tr>
    
    <tr>
       <th>BILL TO ADDRESS</th>
       <td>${ob.billingAddress}</td>
    </tr>
    
     <tr>
       <th>SHIP TO ADDRESS</th>
       <td>${ob.shippingAddress}</td>
    </tr>
    
    </table>
    <a href="excel?id=${ob.id}">Excel View</a>
     <a href="pdf?id=${ob.id}">pdf View</a>

</body>
</html>