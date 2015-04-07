<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Person List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>PersonId</th>
            <th>EmailId</th>
            <th>Password</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>MiddleName</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${personList}" var="person"  varStatus="status">
            <tr>
                <td><a href="edit?personId=${person.personId}">${person.personId}</a></td>
                <td>${person.emailId}</td>
                <td>${person.password}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.middleName}</td>
                <td>
                    <a href="edit?personId=${person.personId}">edit</a> 
                    <a href="show?personId=${person.personId}">view</a>
                    <a href="delete?personId=${person.personId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>