<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <jsp:include page="../fragments/header.jsp" />
    
    <body>
    <div class="container">
        <h3>Enter The Department Details For Update</h3>
        <form:form method="POST" action="${pageContext.request.contextPath}/updateDepartment" modelAttribute="departmentForUpdate">
               <table>
              	<tr>
                    <td><form:label path="departmentId">Employee Id</form:label></td>
                    <td><form:input path="departmentId" readonly="true"/></td>
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
                    <td><input type="submit" value="Update" class="btn btn-primary"/></td>
                </tr>
            </table>
        </form:form>
        
        </div>
        
        <jsp:include page="../fragments/footer.jsp" />
        
    </body>
</html>