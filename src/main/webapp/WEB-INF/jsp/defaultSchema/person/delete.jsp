<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Person</h2>

<c:url value="/person/delete" var="formActionUrl" />

<form:form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this person?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Person Id</th>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Middle Name</th>
                    <th>Activitys</th>
                    <th>Vitalss</th>
                    <th>Weights</th>
                    <th>Email Address</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ person.personId }
                    </td>
                    <td>
                        ${ person.password }
                    </td>
                    <td>
                        ${ person.firstName }
                    </td>
                    <td>
                        ${ person.lastName }
                    </td>
                    <td>
                        ${ person.middleName }
                    </td>
                    <td>
                        <ul>
                            <c:forEach items="${ person.activitys }" var="item" varStatus="itemStatus">
                                <li>${ item.activityId }</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <ul>
                            <c:forEach items="${ person.vitalss }" var="item" varStatus="itemStatus">
                                <li>${ item.vitalsId }</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>
                        <ul>
                            <c:forEach items="${ person.weights }" var="item" varStatus="itemStatus">
                                <li>${ item.weightId }</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>
                        ${ person.emailAddress }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="personId" value="${ person.personId }" />

    </fieldset>
</form:form>