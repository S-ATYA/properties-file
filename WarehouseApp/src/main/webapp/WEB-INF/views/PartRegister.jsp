r<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
      
      <div class="card">
         
         <div class="card-header bg-primary text-white">
               <h3>Welcome to Part Register Page</h3>
         </div>
         
          
         <div class="card-body">
         
            <form:form action="save" method="POST" modelAttribute="part">
                  
                  
		          <div class="row">
		               <div class="col-4">
		                  <label for="partCode">CODE</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="partCode"  class="form-control"/>
		                </div>
		           </div>     
		           
		           
		          <div class="row">
		               <div class="col-4">
		                  <label>DIMENSIONS</label>
		                </div>
		                
		                <div class="col-4">
		                  W <form:input path="width" style="width:95px;" class="form-control"/>
		                  L<form:input path="length" style="width:95px;" class="form-control"/>
		                  H<form:input path="height" style="width:95px;" class="form-control"/>
		                </div>
		           </div>     
		           
		            
		          <div class="row">
		               <div class="col-4">
		                  <label for="baseCost">BASE COST</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="baseCost" class="form-control"/>
		                </div>
		           </div>   
		  
            
                  <div class="row">
		                <div class="col-4"> 
		                   <label for="baseCurrency">BASE CURRENCY</label>   
		                </div>
		                
		                <div class="col-4">
		                    <form:select path="baseCurrency" class="form-control">
		                    <form:option value="">-SELECT-</form:option>
				            <form:option value="INR">INR</form:option>
				            <form:option value="USD">USD</form:option>
				            <form:option value="AUS">AUS</form:option>
				            <form:option value="ERU">ERU</form:option>
				            
		                    </form:select>
		                </div>
		          </div>
		          
		          <hr>
		          
                  <div class="row">
		                <div class="col-4"> 
		                   <label>UOM</label>   
		                </div>
		                
		                <div class="col-4">
		                    <form:select path="Uom.id" class="form-control">
		                    <form:option value="">-SELECT-</form:option>
				            <form:options items="${uoms}"/>
		                    </form:select>
		                </div>
		          </div>
		          
		          <hr>
		          
		           <div class="row">
		                <div class="col-4"> 
		                   <label>ORDER METHOD</label>   
		                </div>
		                
		                <div class="col-4">
		                    <form:select path="OrderMethod.id" class="form-control">
		                    <form:option value="">-SELECT-</form:option>
				            <form:options items="${orders}"/>
		                    </form:select>
		                </div>
		          </div>
		          <hr>
		          
		          <div class="row">
		          
		              <div class="col-4">
		                  <label for="description"> DESCRIPTION </label>
		              </div>
		              
		              <div class="col-4">
		                  <form:textarea path="description" class="form-control" /> 
		              </div>
		              
		           </div>
		           
		           <input type="submit" class="btn btn-success" value="Create"/>
                  
            </form:form>
                
         </div>
         
         <div class="card-footer bg-info">
           <b>${msg}</b>
         </div>
         
      
      
      
      </div>
    
    
    </div>
  
   

</body>
</html>