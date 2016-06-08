<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Step Count</h2>

<c:url value="/stepcount/delete" var="formActionUrl" />

<form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this step count?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Value</th>
                    <th>Measure Start Date</th>
                    <th>Measure End Date</th>
                    <th>Person</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ stepCount.id }
                    </td>
                    <td>
                        ${ stepCount.value }
                    </td>
                    <td>
                        ${ stepCount.measureStartDate }
                    </td>
                    <td>
                        ${ stepCount.measureEndDate }
                    </td>
                    <td>
                        ${ stepCount.person }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="id" value="${ stepCount.id }" />

    </fieldset>
</form>