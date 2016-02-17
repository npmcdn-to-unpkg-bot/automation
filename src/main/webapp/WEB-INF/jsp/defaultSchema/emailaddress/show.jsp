<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Email Address</h2>

<h2> ${emailAddress.emailId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Email Id</th>
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
            ${emailAddress.password}
        </td>
    </tr>
    <tr>
        <th>Persons</th>
        <td>
            <ul>
                <c:forEach items="${emailAddress.persons}" var="item" varStatus="itemStatus" >
                    <li><a href="../person/edit?personId=${item.personId}" > ${item.personId}</a></li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>