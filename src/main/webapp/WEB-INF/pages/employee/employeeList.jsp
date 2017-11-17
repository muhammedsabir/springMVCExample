<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>All Employees</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Surname</th>
					<th>Salary</th>
					<th>Department</th>
				</tr>
			</thead>

			<c:forEach var="employee" items="${allEmployees}">
			    <tr>
				<td>
					${employee.employeeId}
				</td>
				<td>${employee.name}</td>
				<td>${employee.surname}</td>
				<td>${employee.salary}</td>
				<td>${employee.departmentAsStr}</td>
                
				<td>
					  <spring:url value="/employee/${employee.employeeId}/delete" var="deleteUrl" />
					  <spring:url value="/employee/${employee.employeeId}/update" var="updateUrl" />
	
					  <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
					  <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                 </td>
			    </tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>