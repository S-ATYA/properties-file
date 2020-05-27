<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="base">${pageContext.request.requestURL}</c:set>
	<c:set var="url"
		value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


	<!-- ****************MENU BAR STARTS HERE********* -->

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
		<!-- Brand -->
		<a class="navbar-brand " href="#"><img
			src="../resources/images/logo.png" width="100" height="60" /></a>

		<!-- Links -->
		<ul class="navbar-nav">


			<!-- **** START: Uom ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> UOM </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/uom/register">Register</a> <a
						class="dropdown-item" href="${url}/uom/all">View All</a> <a
						class="dropdown-item" href="${url}/uom/charts">Charts</a>
				</div></li>
			<!--** END UOM **-->



			<!-- **** START: PurchaseType ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> PURCHASE TYPE </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/purchase/register">Register</a>
					<a class="dropdown-item" href="${url}/purchase/all">View All</a> <a
						class="dropdown-item" href="${url}/purchase/charts">Charts</a>
				</div></li>
			<!--** END :Purchase Type **-->




			<!-- **** START: Part ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> PART </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/part/register">Register</a>
					<a class="dropdown-item" href="${url}/part/all">View All</a> <a
						class="dropdown-item" href="${url}/part/charts">Charts</a>
				</div></li>
			<!--** END :Part Type **-->

			<!-- **** START: Sale ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> SALE</b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/sale/register">Register</a>
					<a class="dropdown-item" href="${url}/sale/all">View All</a> <a
						class="dropdown-item" href="${url}/sale/charts">Charts</a>
				</div></li>
			<!--** END :Sale Type **-->


			<!-- **** START:whuser type ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> WHUSER TYPE</b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/whuser/register">Register</a>
					<a class="dropdown-item" href="${url}/whuser/all">View All</a> <a
						class="dropdown-item" href="${url}/whuser/charts">Charts</a>
				</div></li>
			<!--** END :whuser Type **-->
			
			<!-- **** START: OM ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> ORDER METHOD </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/ordermethod/register">Register
					</a> <a class="dropdown-item" href="${url}/ordermethod/all">View
						All</a> <a class="dropdown-item" href="${url}/ordermethod/charts">Charts</a>
				</div></li>
			<!--** END OM **-->
			
			<!-- **** START: Shipment Type ***-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> <b> SHIPMENT TYPE </b>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item " href="${url}/shipment/register">Register</a>
					<a class="dropdown-item" href="${url}/shipment/all">View All</a> <a
						class="dropdown-item" href="${url}/shipment/charts">Charts</a>
				</div></li>
			<!--** END : Shipment Type **-->

			<!-- Documents -->
			<li class="nav-item"><a class="nav-link text-white"
				href="${url}/document/register"><b>DOCUMENTS</b></a></li>



			<!-- Logout Link -->
			<li class="nav-item"><a class="nav-link text-white"
				href="${url}/logout"><b>LOGOUT</b></a></li>

		</ul>
	</nav>


</body>
</html>