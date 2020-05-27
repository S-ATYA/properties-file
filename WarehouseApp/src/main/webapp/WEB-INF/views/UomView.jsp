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
       <th>TYPE</th>
       <td>${ob.uomType}</td>
    </tr>
    
     <tr>
       <th>MODEL</th>
       <td>${ob.uomModel}</td>
    </tr>
    
     <tr>
       <th>NOTE</th>
       <td>${ob.description}</td>
    </tr>
    </table>
    <a href="excel?id=${ob.id}"><img src="../resources/images/BulkExcel.png" height="50" width="50"></a>
     <a href="pdf?id=${ob.id}"><img src="../resources/images/BulkPdf.png" height="50" width="50"></a>
</body>
</html>