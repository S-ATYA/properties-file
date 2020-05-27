<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Uom Register Page!!</h3>
			</div>
			<div class="card-body">
				<form:form id="myForm" action="update" method="POST" modelAttribute="uom">
					<!--1st row-->
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
							<label for="uomType">Uom Type</label>
						</div>
						<div class="col-4">
							<form:select path="uomType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PACKING">PACKING</form:option>
								<form:option value="NO PACKING">NO PACKING</form:option>
								<form:option value="NA">NA</form:option>
							</form:select>
						</div>
						<div class="col-4" id="uomTypeError"></div>
					</div>

					<!--2nd row-->
					<div class="row">
						<div class="col-4">
							<label for="uomModel">Uom Model</label>
						</div>
						<div class="col-4">
							<form:input  path="uomModel"
								class="form-control" maxlength="8" />
						</div>
						<div class="col-4" id="uomModelError"></div>
					</div>

					<!--3rd row-->
					<div class="row">
						<div class="col-4">
							<label for="description">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="description"
								class="form-control"/>
						</div>
						<div class="col-4" id="descriptionError"></div>
					</div>

					<input type="submit" class="btn btn-success" value="update" />

				</form:form>
					

			</div>
			<c:if test="${msg ne null}">
				<div class="card-footer bg-info text-white"><b>${msg}</b></div>
			</c:if>
		</div>
	</div>
	<script type="text/javascript" src="../resources/js/uom.js"></script>
        
    

</body>
</html>

