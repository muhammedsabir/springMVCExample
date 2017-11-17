<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>MSabir Homework</title>

<spring:url value="/resources/css/hello.css" var="coreCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="employeeAddForm" var="urlAddEmployee" />
<spring:url value="employeeList" var="urlEmployeeList" />

<spring:url value="departmentAddForm" var="urlAddDepartment" />
<spring:url value="departmentList" var="urlDepartmentList" />

<spring:url value="meetingAddForm" var="urlAddMeeting" />
<spring:url value="meetingList" var="urlMeetingList" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">HOME</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddEmployee}">Add Employee</a></li>
				<li class="active"><a href="${urlEmployeeList}">Employee List</a></li>
				
				<li class="active"><a href="${urlAddDepartment}">Add Department</a></li>
				<li class="active"><a href="${urlDepartmentList}">Department List</a></li>
				
				<li class="active"><a href="${urlAddMeeting}">Add Meeting</a></li>
				<li class="active"><a href="${urlMeetingList}">Meeting List</a></li>
			</ul>
		</div>
	</div>
</nav>