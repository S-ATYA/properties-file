<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Registration</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info"><h2>Welcome To Shipment Model</h2></div>
			<div class="card-body">
				<h6 style="color:red;">${msg}</h6>
				<form:form id="myForm"  action="save" method="POST" modelAttribute="shipmentType">
					<div class="row">
						<div class="col-4">
							<form:label path="shipmentType">Shipment TYPE</form:label>
						</div>
						<div class="col-4">
							<form:select path="shipmentType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="AIR">AIR</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIPS">SHIPS</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
								<form:option value="BUS">BUS</form:option>
							</form:select>
						</div>
						<div class="col-4" id="shipmentTypeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="shipmentCode">Shipment Code</form:label>
						</div>
						<div class="col-4">
							<form:input path="shipmentCode" id="shipmentCode" class="form-control" />
						</div>
						<div class="col-4" id="shipmentCodeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="shipmentEnable">Enable Shipment</form:label>
						</div>
						<div class="col-4">
							<form:select path="shipmentEnable"  class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="YES">YES</form:option>
								<form:option value="NO">NO</form:option>
							</form:select>
						</div>
						<div class="col-4" id="shipmentEnableError"></div>
					</div>
					<div class="row"> 
						<div class="col-4">
							<form:label path="shipmentGrade">Shipment Grade</form:label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipmentGrade"  value="A" />A
							<form:radiobutton path="shipmentGrade"  value="B" />B
							<form:radiobutton path="shipmentGrade"  value="C" />C
						</div>
						<div class="col-4" id="shipmentGradeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="description">Description</form:label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control" />
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<input type="submit" value="Submit" class="btn btn-success" />
					<input type="reset" value="CLEAR" class="btn btn-danger" />
				</form:form>
				
			</div>	
			<div class="card-footer bg-info">SHIPMENT SUCCESS</div>
		</div>
		<br><br>
		
	</div>
<script type="text/javascript"  src="../resources/js/ShipmentRegister.js"></script>
</body>
</html>