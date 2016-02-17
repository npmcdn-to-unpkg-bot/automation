<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Weight List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>Weight Id</th>
            <th>Value</th>
            <th>Weight In Date</th>
            <th>Person</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ weightList }" var="weight"  varStatus="status">
            <tr>
                <td><a href="edit?weightId=${weight.weightId}">${weight.weightId}</a></td>
                <td>${weight.value}</td>
                <td>${weight.weightInDate}</td>
                <td>${weight.person.personId}</td>
                <td>
                    <a href="edit?weightId=${weight.weightId}">edit</a> 
                    <a href="show?weightId=${weight.weightId}">view</a>
                    <a href="delete?weightId=${weight.weightId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>