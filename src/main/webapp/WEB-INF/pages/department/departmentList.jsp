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

		<h1>All Departments</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Description</th>
			</thead>

			<c:forEach var="department" items="${allDepartments}">
			    <tr>
				<td>
					${department.departmentId}
				</td>
				<td>${department.name}</td>
				<td>${department.description}</td>
                
				<td>
					  <spring:url value="/department/${department.departmentId}/delete" var="deleteUrl" />
					  <spring:url value="/department/${department.departmentId}/update" var="updateUrl" />
	
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