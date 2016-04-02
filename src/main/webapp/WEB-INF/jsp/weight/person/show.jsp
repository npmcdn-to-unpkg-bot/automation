<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Person</h2>

<h2> ${person.personId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Person Id</th>
        <td>
            ${person.personId}
        </td>
    </tr>
    <tr>
        <th>Password</th>
        <td>
            ${person.password}
        </td>
    </tr>
    <tr>
        <th>First Name</th>
        <td>
            ${person.firstName}
        </td>
    </tr>
    <tr>
        <th>Last Name</th>
        <td>
            ${person.lastName}
        </td>
    </tr>
    <tr>
        <th>Middle Name</th>
        <td>
            ${person.middleName}
        </td>
    </tr>
    <tr>
        <th>Activitys</th>
        <td>
            <ul>
                <c:forEach items="${person.activitys}" var="item" varStatus="itemStatus" >
                    <li><a href="../activity/edit?activityId=${item.activityId}" > ${item.activityId}</a></li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    <tr>
        <th>Vitalss</th>
        <td>
            <ul>
                <c:forEach items="${person.vitalss}" var="item" varStatus="itemStatus" >
                    <li><a href="../vitals/edit?vitalsId=${item.vitalsId}" > ${item.vitalsId}</a></li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    <tr>
        <th>Weights</th>
        <td>
            <ul>
                <c:forEach items="${person.weights}" var="item" varStatus="itemStatus" >
                    <li><a href="../weight/edit?weightId=${item.weightId}" > ${item.weightId}</a></li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    <tr>
        <th>Email Address</th>
        <td>
            ${person.emailAddress}
        </td>
    </tr>
</table>