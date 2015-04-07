<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Weight</h2>
<h2> ${weight.weightId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>WeightId</th>
        <td>
            ${weight.weightId}
        </td>
    </tr>
    <tr>
        <th>PersonId</th>
        <td>
            ${weight.personId}
        </td>
    </tr>
    <tr>
        <th>Value</th>
        <td>
            ${weight.value}
        </td>
    </tr>
    <tr>
        <th>WeightInDate</th>
        <td>
            ${weight.weightInDate}
        </td>
    </tr>
</table>