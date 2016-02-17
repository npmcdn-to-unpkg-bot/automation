<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Activity</h2>

<c:url value="/activity/delete" var="formActionUrl" />

<form:form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this activity?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Activity Id</th>
                    <th>Value</th>
                    <th>Activity Date</th>
                    <th>Person</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ activity.activityId }
                    </td>
                    <td>
                        ${ activity.value }
                    </td>
                    <td>
                        ${ activity.activityDate }
                    </td>
                    <td>
                        ${ activity.person }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="activityId" value="${ activity.activityId }" />

    </fieldset>
</form:form>