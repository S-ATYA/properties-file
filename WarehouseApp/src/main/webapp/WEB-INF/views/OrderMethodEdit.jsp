<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="update" method="POST" modelAttribute="ordermethod">
    	<pre>
  ID:<form:input path="id" readOnly="true" />  	
 ORDER MODE: <form:radiobutton path="orderMode" value="sale" />sale
              <form:radiobutton path="orderMode"  value="purchase"/>purchase
 ORDER CODE:<form:input path="orderCode" />  
           
 ORDER TYPE:<form:select path="orderType">
    			<form:option value="">-SELECT-</form:option>
    			<form:option value="FIFO">FIFO</form:option>
    			<form:option value="LIFO">LIFO</form:option>
    			<form:option value="FCFO">FCFO</form:option>
    			<form:option value="FEFO">FEFO</form:option>
    			</form:select>
       	
 ORDER Accept: <form:checkbox path="orderAccept" value="multi-model" />multi-model
              <form:checkbox path="orderAccept" value="accept return" />accept return 
              
              
  DESCRIPTION:<form:textarea path="description"/>   
  
  <input type="submit" value="update" />          
              </pre>
   </form:form>           
</body>
</html>