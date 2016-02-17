<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Email Address</h2>

<c:url value="/emailaddress/delete" var="formActionUrl" />

<form:form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this email address?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Email Id</th>
                    <th>Address</th>
                    <th>Password</th>
                    <th>Persons</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ emailAddress.emailId }
                    </td>
                    <td>
                        ${ emailAddress.address }
                    </td>
                    <td>
                        ${ emailAddress.password }
                    </td>
                    <td>
                        <ul>
                            <c:forEach items="${ emailAddress.persons }" var="item" varStatus="itemStatus">
                                <li>${ item.personId }</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="emailId" value="${ emailAddress.emailId }" />

    </fieldset>
</form:form>