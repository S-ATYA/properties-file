<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Module</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h3>Welcome To Purchase Model Registration Page</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="purchase" id="purchaseForm">
					<div class="row">
						<div class="col-4">
							<form:label path="orderCode">ORDER CODE</form:label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4" id="orderCodeError"></div>
					</div>	
					<div class="row">
						<div class="col-4">
							<form:label path="shipmentCode">SHIPMENT CODE</form:label>
						</div>
						<div class="col-4">
							<form:select path="shipmentCode.id" class="form-control">
							<form:option value="">-SELECT-</form:option>
								<form:options items="${shipmentCode}"/>
							</form:select>
						</div>
						<div class="col-4" id="shipmentModeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="whUser">VENDOR</form:label>
						</div>
						<div class="col-4">
							<form:select path="whUser.id" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${whUserType}"/>
							</form:select>
						</div>
						<div class="col-4" id="whUserError"></div>
					</div>
					<div class="row">	
						<div class="col-4">
							<form:label path="referenceNumebr">REFERENCE NUMBER</form:label>
						</div>
						<div class="col-4">
							<form:input path="referenceNumebr" class="form-control" />
						</div>
						<div class="col-4" id="referenceNumberError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="qualityCheck">QUALITY CHECK</form:label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qualityCheck" value="Required" />REQUIRED
							<form:radiobutton path="qualityCheck" value="Not Required" />NOT REQUIRED
						</div>
						<div class="col-4" id="qualityCheckError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="defaultStatus" >DEFAULT STATUS</form:label>
						</div>
						<div class="col-4">
							<form:input class="form-control" path="defaultStatus"  readonly="true" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="description">DESCRIPTION</form:label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control" />
						</div> 
						<div class="col-4" id="descriptionError"></div>
					</div>
					<input type="submit" value="Submit" class="btn btn-success" />
				</form:form>
			</div>
			<div class="card-footer bg-dark text-white text-center">
				${msg}
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/PurchaseRegister.js"></script>
</body>
</html>