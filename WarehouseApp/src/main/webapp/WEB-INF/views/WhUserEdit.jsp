<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUser Edit Page</title>
</head>
<body>
<%@include file="usermenu.jsp" %>
<div class="container">
	<div class="card">
		<div class="card-header bg-primary text-white text-center">
			<h4>Welcome To WhUser Edit Page</h4>
		</div>
		<div class="card-body">
			<form:form action="update" method="POST" modelAttribute="whuser">
				<div class="row">
					<div class="col-4">
						<form:label path="id">ID</form:label>
					</div>
					<div class="col-4">
						<form:input path="id" readonly="true"/>
					</div>
				</div>
				<div class="row">
						<div class="col-4">
							<form:label path="userType">USER TYPE</form:label>
						</div>
						<div class="col-4">
							VENDOR<form:radiobutton path="userType"  value="VENDOR" />
							CUSTOMER<form:radiobutton path="userType"  value="CUSTOMER"/>
						</div>
						<div class="col-4" id="userTypeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="userCode">USER CODE</form:label>
						</div>
						<div class="col-4">
							<form:input path="userCode" class="form-control" />
						</div>
						<div class="col-4" id="userCodeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userFor">USER FOR</label>
						</div>
						<div class="col-4">
							<form:input path="userFor" class="form-control" readonly="true"/>
						</div>
						<div class="col-4" id="userForError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="userEmail">USER EMAIL</form:label>
						</div>
						<div class="col-4">
							<form:input path="userEmail"  class="form-control"/>
						</div>
						<div class="col-4" id="userEmailError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="mobileNumber">USER MOBILE</form:label>
						</div>
						<div class="col-4">
							<form:input path="mobileNumber" class="form-control" />
						</div>
						<div class="col-4" id="mobileNumberError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="idType">USER ID TYPE</form:label>
						</div>
						<div class="col-4">
							<form:select path="idType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PANCARD">PAN CARD</form:option>
								<form:option value="AADHARCARD">AADHAR CARD</form:option>
								<form:option value="DRIVING LIESENCE">DRIVING LIESENCE</form:option>
								<form:option value="VOTER ID">VOTER ID</form:option>
								<form:option value="OTHERS">OTHERS</form:option>
							</form:select>
						</div>
						<div class="col-4" id="idTypeError"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<form:label path="othersId">OTHERS</form:label>
						</div>
						<div class="col-4">
							<form:input path="othersId" class="form-control"/>
						</div>
						<div class="col-4" id="othersIdError"></div>
					</div>
					<div class="row">
						<div class="col">
							<form:label path="idNumber">ID NUMBER</form:label>
						</div>
						<div class="col">
							<form:input path="idNumber" class="form-control"/>
						</div>
						<div class="col" id="idNumberErro"></div>
					</div>
					<input type="submit" value="Create User" class="btn btn-success">
				</form:form>
			</div>
		<div class="card-footer bg-dark text-white text-center">
			<h6>All Copy rights reserved  </h6>
		</div>
	</div>
</div>
<script type="text/javascript" src="../resources/js/whUser.js"></script>
</body>
</html>