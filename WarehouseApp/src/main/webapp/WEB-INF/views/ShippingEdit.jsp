<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
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
               <h3>Welcome to Shipping Register Page</h3>
         </div>
         
         <div class="card-body">
         
             <form:form action="update" method="POST" modelAttribute="shipping">
             
                <div class="row">
		               <div class="col-4">
		                  <label for="sCode">SHIPPING CODE</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="shippingCode" id="sCode" class="form-control"/>
		                </div>
		                
		         </div> 
		         
		         
                <div class="row">
                
		               <div class="col-4">
		                  <label for="sRefNo">SHIPPING REF NO</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="refNo" id="sRefNo" class="form-control"/>
		                </div>
		                
		         </div>  
		         
		           
                <div class="row">
                
		               <div class="col-4">
		                  <label for="RefNo">COURIER REF NO</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="CrefNo" id="CRefNo" class="form-control"/>
		                </div>
		                
		         </div>
		         
		         
		          <div class="row">
                
		               <div class="col-4">
		               <label for="cdetails">CONTACT DETAILS</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:textarea path="cdetails" id="cdetails" class="form-control"/>
		                </div>
		                
		         </div>   
		         
		         
		          <div class="row">
                
		               <div class="col-4">
		                  <label for="ocode">SALE ORDER CODE</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="orderCode" id="ocode" class="form-control"/>
		                </div>
		                
		         </div>  
		         
		         
		         
		          <div class="row">
                
		               <div class="col-4">
		               <label for="desc">DESCRIPTION</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:textarea path="description" id="esc" class="form-control"/>
		                </div>
		                
		         </div>  
		         
		         
		         <div class="row">
                
		               <div class="col-4">
		               <label for="baddr">BILL TO ADDRESS</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:textarea path="billingAddress" id="baddr" class="form-control"/>
		                </div>
		                
		         </div>   
		         
		         
		         
		         <div class="row">
                
		               <div class="col-4">
		               <label for="saddr">SHIP TO ADDRESS</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:textarea path="shippingAddress" id="saddr" class="form-control"/>
		                </div>
		                
		         </div>   
		         
		          <input type="submit" class="btn btn-success" value="update"/>
                  
		           
             
             </form:form>
         
         </div>
         
          <div class="card-footer bg-info">
           <b>SUCCESS</b>
         </div>
         
      </div>
      
   </div>
       ${msg}

</body>
</html>