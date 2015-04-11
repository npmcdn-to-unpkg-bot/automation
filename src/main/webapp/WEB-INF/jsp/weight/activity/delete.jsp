<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Activity</h2>

<form method="post" action="delete">
    <fieldset>
        <legend>Are you sure you want to delete this Activity?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>ActivityId</th>
                    <th>PersonId</th>
                    <th>Value</th>
                    <th>ActivityDate</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ activity.activityId }
                    </td>
                    <td>
                        ${ activity.personId }
                    </td>
                    <td>
                        ${ activity.value }
                    </td>
                    <td>
                        ${ activity.activityDate }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="activityId" value="${ activity.activityId }" />

    </fieldset>
</form>