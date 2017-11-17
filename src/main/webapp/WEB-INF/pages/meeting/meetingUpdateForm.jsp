<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <jsp:include page="../fragments/header.jsp" />
    
    <body>
    <div class="container">
        <h3>Enter The Meeting Details For Update</h3>
        <form:form method="POST" action="${pageContext.request.contextPath}/updateMeeting" modelAttribute="meetingForUpdate">
               <table>
              	<tr>
                    <td><form:label path="meetingId">Meeting Id</form:label></td>
                    <td><form:input path="meetingId"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                  <tr>
                    <td><form:label path="departmentId">Department Id</form:label></td>
                    <td>
						<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:select path="departmentId" class="form-control">
									<form:option value="0" label="--- Select ---" />
									<form:options items="${departmentList}" />
								</form:select>
								<form:errors path="departmentId" class="control-label" />
						</div>
                    </td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Update" class="btn btn-primary"/></td>
                </tr>
            </table>
        </form:form>
        
        </div>
        
        <jsp:include page="../fragments/footer.jsp" />
        
    </body>
</html>