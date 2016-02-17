<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Weight</h2>

<h2> ${weight.weightId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Weight Id</th>
        <td>
            ${weight.weightId}
        </td>
    </tr>
    <tr>
        <th>Value</th>
        <td>
            ${weight.value}
        </td>
    </tr>
    <tr>
        <th>Weight In Date</th>
        <td>
            ${weight.weightInDate}
        </td>
    </tr>
    <tr>
        <th>Person</th>
        <td>
            ${weight.person}
        </td>
    </tr>
</table>