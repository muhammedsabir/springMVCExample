<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
    </head>
    
    <jsp:include page="../fragments/header.jsp" />
    
    <body>
    
     <div class="container">
     
        <h3>Enter The department Details</h3>
        <form:form method="POST" action="${pageContext.request.contextPath}/addDepartment" modelAttribute="department">
               <table>
              	<tr>
                    <td><form:label path="departmentId">Department Id</form:label></td>
                    <td><form:input path="departmentId"/></td>
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
                    <td><input type="submit" value="Add" class="btn btn-primary"/></td>
                </tr>
            </table>
        </form:form>
        
        </div>
        
     <jsp:include page="../fragments/footer.jsp" />
        
    </body>
    
</html>