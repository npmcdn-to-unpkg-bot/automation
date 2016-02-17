<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Weight</h2>

<c:url value="/weight/delete" var="formActionUrl" />

<form:form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this weight?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Weight Id</th>
                    <th>Value</th>
                    <th>Weight In Date</th>
                    <th>Person</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ weight.weightId }
                    </td>
                    <td>
                        ${ weight.value }
                    </td>
                    <td>
                        ${ weight.weightInDate }
                    </td>
                    <td>
                        ${ weight.person }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="weightId" value="${ weight.weightId }" />

    </fieldset>
</form:form>