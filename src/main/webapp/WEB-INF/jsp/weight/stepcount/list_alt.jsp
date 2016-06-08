<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Step Count List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>Id</th>
            <th>Value</th>
            <th>Measure Start Date</th>
            <th>Measure End Date</th>
            <th>Person</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ stepCountList }" var="stepCount"  varStatus="status">
            <tr>
                <td><a href="edit?id=${stepCount.id}">${stepCount.id}</a></td>
                <td>${stepCount.value}</td>
                <td>${stepCount.measureStartDate}</td>
                <td>${stepCount.measureEndDate}</td>
                <td>${stepCount.person.personId}</td>
                <td>
                    <a href="edit?id=${stepCount.id}">edit</a> 
                    <a href="show?id=${stepCount.id}">view</a>
                    <a href="delete?id=${stepCount.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>