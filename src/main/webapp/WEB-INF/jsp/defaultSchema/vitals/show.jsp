<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Vitals</h2>

<h2> ${vitals.vitalsId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Vitals Id</th>
        <td>
            ${vitals.vitalsId}
        </td>
    </tr>
    <tr>
        <th>Vitals Date</th>
        <td>
            ${vitals.vitalsDate}
        </td>
    </tr>
    <tr>
        <th>Systolic</th>
        <td>
            ${vitals.systolic}
        </td>
    </tr>
    <tr>
        <th>Diatolic</th>
        <td>
            ${vitals.diatolic}
        </td>
    </tr>
    <tr>
        <th>Pulse</th>
        <td>
            ${vitals.pulse}
        </td>
    </tr>
    <tr>
        <th>Comment</th>
        <td>
            ${vitals.comment}
        </td>
    </tr>
    <tr>
        <th>Person</th>
        <td>
            ${vitals.person}
        </td>
    </tr>
</table>