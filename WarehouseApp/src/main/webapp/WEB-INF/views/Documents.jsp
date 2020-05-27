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
   <h3>WELCOME TO DOCUMENTS PAGE</h3>
   <form action="upload" method="post"  enctype="multipart/form-data">
   
      <pre>
        
        ID:<input type="text" name="fid" />
        DOC:<input type="file" name="fdoc" />
        <input type="submit" value="upload" />
      </pre>
   
   </form>
   
   <table border="1">
   
     <tr>
        <th>FILE NAME</th>
        <th>DOWNLOAD LINK</th>
     </tr>
     
     <c:forEach items="${list}" var="ob">
     <tr>
         <td>${ob[1]}</td>
         <td>
         <a href="download?fid=${ob[0]}"><img src="../resources/images/download.png" height="20" width="20" ></a></td>
     </tr>
     </c:forEach>
   </table>
</body>
</html>