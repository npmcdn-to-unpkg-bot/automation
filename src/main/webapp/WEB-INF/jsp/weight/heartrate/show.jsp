<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Heart Rate</h2>

<h2> ${heartRate.heartRateId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Heart Rate Id</th>
        <td>
            ${heartRate.heartRateId}
        </td>
    </tr>
    <tr>
        <th>Value</th>
        <td>
            ${heartRate.value}
        </td>
    </tr>
    <tr>
        <th>Measure Date</th>
        <td>
            ${heartRate.measureDate}
        </td>
    </tr>
    <tr>
        <th>Person</th>
        <td>
            ${heartRate.person}
        </td>
    </tr>
</table>