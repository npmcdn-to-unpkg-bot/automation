<%@ include file="/WEB-INF/include.jsp"  %>

<h2>EmailAddress List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>EmailId</th>
            <th>Address</th>
            <th>Password</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${emailAddressList}" var="emailAddress"  varStatus="status">
            <tr>
                <td><a href="edit?emailId=${emailAddress.emailId}">${emailAddress.emailId}</a></td>
                <td>${emailAddress.address}</td>
                <td>${emailAddress.password}</td>
                <td>
                    <a href="edit?emailId=${emailAddress.emailId}">edit</a> 
                    <a href="show?emailId=${emailAddress.emailId}">view</a>
                    <a href="delete?emailId=${emailAddress.emailId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>