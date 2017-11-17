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

		<h1>All Meetings</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Department</th>
				</tr>
			</thead>

			<c:forEach var="meeting" items="${allMeetings}">
			    <tr>
				<td>
					${meeting.meetingId}
				</td>
				<td>${meeting.name}</td>
				<td>${meeting.description}</td>
				<td>${meeting.departmentAsStr}</td>
                
				<td>
					  <spring:url value="/meeting/${meeting.meetingId}/update" var="updateUrl" />
					  <spring:url value="/meeting/${meeting.meetingId}/delete" var="deleteUrl" />
	
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