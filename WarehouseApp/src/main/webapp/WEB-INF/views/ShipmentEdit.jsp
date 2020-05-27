<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHIPMENT EDIT PAGE</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h3>WELCOME TO SHIPMETN TYPE UPDATION PAGE</h3>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="update" method="POST" modelAttribute="ships">
					<div class="row">
						<div class="col-4">
							<form:label path="id">ID</form:label>
						</div>
						<div class="col-4">
							<form:input path="id" readonly="true" />
						</div>
						
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="">SHIPMENT TYPE</form:label>
						</div>
						<div class="col-4">
							<form:select path="shipmentType">
								<form:option value="">-SELECT-</form:option>
								<form:option value="AIR">AIR</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIPS">BUS</form:option>
							</form:select>
						</div>
						<div class="col-4" id="shipmentTypeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="">SHIPMENT CODE</form:label>
						</div>
						<div class="col-4">
							<form:input path="shipmentCode" />
						</div>
						<div class="col-4" id="shipmentCodeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="shipmentEnable">SHIPMENT ENABLE</form:label>
						</div>
						<div class="col-4">
							<form:select path="shipmentEnable">
								<form:option value="">-SELECT-</form:option>
								<form:option value="YES">YES</form:option>
								<form:option value="NO">NO</form:option>
							</form:select>
						</div>
						<div class="col-4" id="shipmentEnableError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="">SHIPMENT GRADE</form:label>
						</div>
						<div class="col-4">
							A<form:radiobutton path="shipmentGrade" value="A" />
							B<form:radiobutton path="shipmentGrade" value="B" />
							C<form:radiobutton path="shipmentGrade" value="C" />
						</div>
						<div class="col-4" id="shipmentGradeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="">DESCRIPTION</form:label>
						</div>
						<div class="col-4">
							<form:textarea path="description" />
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>
					<input type="submit" value="Update Shipment" class="btn btn-primary">
				</form:form>
			</div>
			<div class="card-footer bg-dark text-white text-center">
				<h5>All copy Right Reserved</h5>
			</div>
		</div>
	</div>
	<script type="text/javascript"  src="../resources/js/ShipmentRegister.js"></script>
</body>
</html>