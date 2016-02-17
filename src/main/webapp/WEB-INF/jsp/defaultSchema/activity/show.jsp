<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Activity</h2>

<h2> ${activity.activityId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Activity Id</th>
        <td>
            ${activity.activityId}
        </td>
    </tr>
    <tr>
        <th>Value</th>
        <td>
            ${activity.value}
        </td>
    </tr>
    <tr>
        <th>Activity Date</th>
        <td>
            ${activity.activityDate}
        </td>
    </tr>
    <tr>
        <th>Person</th>
        <td>
            ${activity.person}
        </td>
    </tr>
</table>