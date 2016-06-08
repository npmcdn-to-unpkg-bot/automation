<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Step Count</h2>

<h2> ${stepCount.id} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Id</th>
        <td>
            ${stepCount.id}
        </td>
    </tr>
    <tr>
        <th>Value</th>
        <td>
            ${stepCount.value}
        </td>
    </tr>
    <tr>
        <th>Measure Start Date</th>
        <td>
            ${stepCount.measureStartDate}
        </td>
    </tr>
    <tr>
        <th>Measure End Date</th>
        <td>
            ${stepCount.measureEndDate}
        </td>
    </tr>
    <tr>
        <th>Person</th>
        <td>
            ${stepCount.person}
        </td>
    </tr>
</table>