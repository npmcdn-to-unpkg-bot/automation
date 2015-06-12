<%@ include file="/WEB-INF/include.jsp"  %>

<h2>EmailAddress</h2>
<h2> ${emailAddress.emailId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>EmailId</th>
        <td>
            ${emailAddress.emailId}
        </td>
    </tr>
    <tr>
        <th>Address</th>
        <td>
            ${emailAddress.address}
        </td>
    </tr>
    <tr>
        <th>Password</th>
        <td>
            HIDDEN
        </td>
    </tr>
</table>