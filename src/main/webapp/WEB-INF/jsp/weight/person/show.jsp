<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Person</h2>
<h2> ${person.personId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>PersonId</th>
        <td>
            ${person.personId}
        </td>
    </tr>
    <tr>
        <th>EmailId</th>
        <td>
            ${person.emailId}
        </td>
    </tr>
    <tr>
        <th>Password</th>
        <td>
            ${person.password}
        </td>
    </tr>
    <tr>
        <th>FirstName</th>
        <td>
            ${person.firstName}
        </td>
    </tr>
    <tr>
        <th>LastName</th>
        <td>
            ${person.lastName}
        </td>
    </tr>
    <tr>
        <th>MiddleName</th>
        <td>
            ${person.middleName}
        </td>
    </tr>
</table>