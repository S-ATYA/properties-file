<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%@include file="usermenu.jsp" %>
<div class="container">
<table class="table table-bordered bg-info text-white">
<tr>
 <td> <b>Order Code: ${parent.orderCode}</b></td>
</tr>
<tr> 
 <td><b>Status    : ${parent.defaultStatus}</b></td>
</tr>
</table>

<h3>Choose Parts Here</h3>
<form:form action="add" method="POST" modelAttribute="purchaseDetails">
<pre>
PART: <form:select path="part.id" class="form-control">
	<form:option value="">-SELECT-</form:option>
	<form:options items="${partsDetails}"/>
</form:select>
QNTY: <form:input path="quantity" class="form-control"/>
<form:hidden path="parent.id"/>
<input type="submit" value="Add" class="btn btn-success"/>
</pre>
</form:form>


<table class="table">
	<tr>
		<th>Slno</th>
		<th>Part</th>
		<th>Base Cost</th>
		<th>Qnty</th>
		
	</tr>
	<c:forEach items="${parent.childs}" var="ob">
		<tr>
			<td><c:out value="${ob.slno}"/> </td>
			<td><c:out value="${ob.part.partCode}"/> </td>
			<td><c:out value="${ob.part.baseCost}"/> </td>
			<td><c:out value="${ob.quantity}"/> </td>
			<td>
				<c:if test="${parent.defaultStatus eq 'PICKING' }">
				<a href="remove?id=${parent.id}&dtlId=${ob.id}">
				  <img src="../resources/images/delete.png" width="35" height="35">
				</a>
				</c:if>
			</td>
		</tr> 
	</c:forEach>
</table>

	

</div>
</body>
</html>







