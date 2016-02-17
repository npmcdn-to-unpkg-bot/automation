<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Activity List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>Activity Id</th>
            <th>Value</th>
            <th>Activity Date</th>
            <th>Person</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ activityList }" var="activity"  varStatus="status">
            <tr>
                <td><a href="edit?activityId=${activity.activityId}">${activity.activityId}</a></td>
                <td>${activity.value}</td>
                <td>${activity.activityDate}</td>
                <td>${activity.person.personId}</td>
                <td>
                    <a href="edit?activityId=${activity.activityId}">edit</a> 
                    <a href="show?activityId=${activity.activityId}">view</a>
                    <a href="delete?activityId=${activity.activityId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>