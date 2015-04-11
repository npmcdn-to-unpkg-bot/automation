<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Activity</h2>
<h2> ${activity.activityId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>ActivityId</th>
        <td>
            ${activity.activityId}
        </td>
    </tr>
    <tr>
        <th>PersonId</th>
        <td>
            ${activity.personId}
        </td>
    </tr>
    <tr>
        <th>Value</th>
        <td>
            ${activity.value}
        </td>
    </tr>
    <tr>
        <th>ActivityDate</th>
        <td>
            ${activity.activityDate}
        </td>
    </tr>
</table>