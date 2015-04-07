<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Weight</h2>

<form method="post" action="delete">
    <fieldset>
        <legend>Are you sure you want to delete this Weight?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>WeightId</th>
                    <th>PersonId</th>
                    <th>Value</th>
                    <th>WeightInDate</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ weight.weightId }
                    </td>
                    <td>
                        ${ weight.personId }
                    </td>
                    <td>
                        ${ weight.value }
                    </td>
                    <td>
                        ${ weight.weightInDate }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="weightId" value="${ weight.weightId }" />

    </fieldset>
</form>