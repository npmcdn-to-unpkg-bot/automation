<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Activity List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>ActivityId</th>
            <th>PersonId</th>
            <th>Value</th>
            <th>ActivityDate</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${activityList}" var="activity"  varStatus="status">
            <tr>
                <td><a href="edit?activityId=${activity.activityId}">${activity.activityId}</a></td>
                <td>${activity.personId}</td>
                <td>${activity.value}</td>
                <td>${activity.activityDate}</td>
                <td>
                    <a href="edit?activityId=${activity.activityId}">edit</a> 
                    <a href="show?activityId=${activity.activityId}">view</a>
                    <a href="delete?activityId=${activity.activityId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>