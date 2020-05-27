<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    
   
      
      <div class="container">
       
          <div class="card">
          
             <div class="header bg-primary text-white">
               
                   <h1  style="text-align:center">WELCOME TO SALE</h1>
               
             </div><br>
             
              
             
                <div class="card-body">
                
                    <form:form action="save" method="post" modelAttribute="sale">
                    
                     <div class="row">         

                                 <div class="col-4">
                                     <label for="ocode">SALE CODE:
                                     </label>
                                 </div>
                                 
                                  <div class="col-4"> 
                                      <form:input  id="ocode" class="form-controller" path="orderCode" />
                                  </div>
                      </div>
                      
                             
                  <div class="row">
                  
                       <div class="col-4">
                           <label for="mode">SHIPMENT MODE:</label>
                       </div>
                        
                    <div class="col-4">
                     <form:select path="type.id" class="form-control">
                      <form:options items="${shipments}" />
                       <form:option value="">--SELECT--</form:option>
                       
                     </form:select>  
                      
                    </div>
                    
                  </div>   
                      
                   <div class="row">         

                                 <div class="col-4">
                                     <label for="omode">CUSTOMER:
                                     </label>
                                 </div>
                                 
                                  <div class="col-4"> 
                                      <form:input id="omode" class="form-controller" path="customer" />
                                  </div>
                    </div>
                    
                     <div class="row">         

                                 <div class="col-4">
                                     <label for="ref">REF NO:
                                     </label>
                                 </div>
                                 
                                  <div class="col-4"> 
                                      <form:input id="ref" class="form-controller" path="referenceNo" />
                                  </div>
                                  
                      </div>
                      
                      <div class="row">
                    
                                <div class="col-4">
                                    <label>STOCK MODE:</label> 
                                 </div>
                                 <div class="col-4">
                                    <form:checkbox path="stockMode" value="grade"/>GRADE
                                     <form:checkbox path="stockMode" value="margin"/>MARGIN
                                  </div>
                        </div>
                        
                        
                   <div class="row">
                  
                       <div class="col-4">
                           <label for="stockSource">STOCK SOURCE:</label>
                       </div>
                        
                    <div class="col-4">
                     
                       
                       <form:select path="stockSource"  class="form-control">
                       <form:option value="">--SELECT--</form:option>
                       <form:option value="open">OPEN</form:option>
                       <form:option value="avail">AVAIL</form:option>
                       <form:option value="refund">REFUND</form:option>
                       <form:option value="other">OTHER</form:option>
                      </form:select>
                     	
                    </div>
                    
                  </div>  
                  
                  
                  
                      
                      
                  <div class="row">
                        <div class="col-4">
                             <label for="desc">DESCRIPTION</label>
                        </div>
                        <div class="col-4">
                           <textarea name="description" id="desc" class="form-control"></textarea>
                        </div>
                  </div>
                    
                      
                  <div class="row">
                  
                     <div class="col-4"></div>
                     <div class="col-4">
                         <input type="submit" value="create sale order" class="btn btn-success">
                     </div>
                     
                  </div>
                  
                </form:form>   
                    
                      
                
                
            <br>    
           <div class="card-footer bg-info">
               <b>SUCCESS</b>
          </div>
          
          
           </div>
         
         </div> 
         </div>
         
          
      
                 
    
    
    
    ${message}
    
</body>
</html>