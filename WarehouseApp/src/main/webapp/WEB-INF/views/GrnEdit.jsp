<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <div class="container">
      
      <div class="card">
         
         <div class="card-header bg-primary text-white">
               <h3>Welcome to Grn Register Page</h3>
         </div>
         
          
         <div class="card-body">
         
            <form:form action="update" method="POST" modelAttribute="grn">
                  
                  
		          <div class="row">
		               <div class="col-4">
		                  <label for="grnCode">GRN CODE</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="grnCode" id="grnCode" class="form-control"/>
		                </div>
		           </div>     
		           
		           
		          <div class="row">
		               <div class="col-4">
		                  <label for="grnType">GRN TYPE</label>
		                </div>
		                
		                <div class="col-4">
		                   <form:input path="grnType" id="grnType" class="form-control"/>
		                </div>
		           </div>     
		  
            
                  <div class="row">
		                <div class="col-4"> 
		                   <label for="grnOCode">ORDER CODE</label>   
		                </div>
		                
		                <div class="col-4">
		                    <form:select path="grnOCode" id="grnOCode" class="form-control">
		                    <form:option value="">-SELECT-</form:option>
				            <form:option value="PACKING">PACKING</form:option>
				            <form:option value="NO PACKING">NO PACKING</form:option>
				            <form:option value="NA">-NA-</form:option>
		                    </form:select>
		                </div>
		          </div>
		          
		          
		          <div class="row">
		          
		              <div class="col-4">
		                  <label for="description"> DESCRIPTION </label>
		              </div>
		              
		              <div class="col-4">
		                  <form:textarea path="description" id="description" class="form-control" /> 
		              </div>
		              
		           </div>
		           
		           <input type="submit" class="btn btn-success" value="UPDATE GRN"/>
                  
            </form:form>
                
         </div>
         
         <div class="card-footer bg-info">
           <b>SUCCESS</b>
         </div>
         
      
      
      
      </div>
    
    
    </div>
    
</body>
</html>