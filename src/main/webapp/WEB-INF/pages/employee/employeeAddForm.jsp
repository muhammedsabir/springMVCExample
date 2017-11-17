<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
    </head>
    
    <jsp:include page="../fragments/header.jsp" />
    
    <body>
    
     <div class="container">
     
        <h3>Enter The Employee Details</h3>
        <form:form method="POST" action="${pageContext.request.contextPath}/addEmployee" modelAttribute="employee">
               <table>
              	<tr>
                    <td><form:label path="employeeId">Employee Id</form:label></td>
                    <td><form:input path="employeeId"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="surname">Surname</form:label></td>
                    <td><form:input path="surname"/></td>
                </tr>
                <tr>
                    <td><form:label path="salary">Salary</form:label></td>
                    <td><form:input path="salary"/></td>
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
                    <td><input type="submit" value="Add" class="btn btn-primary"/></td>
                </tr>
            </table>
        </form:form>
        
        </div>
        
     <jsp:include page="../fragments/footer.jsp" />
        
    </body>
    
</html>