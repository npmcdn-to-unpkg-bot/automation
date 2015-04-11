<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Vitals</h2>

<form method="post" action="delete">
    <fieldset>
        <legend>Are you sure you want to delete this Vitals?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>VitalsId</th>
                    <th>PersonId</th>
                    <th>VitalsDate</th>
                    <th>Systolic</th>
                    <th>Diatolic</th>
                    <th>Pulse</th>
                    <th>Comment</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ vitals.vitalsId }
                    </td>
                    <td>
                        ${ vitals.personId }
                    </td>
                    <td>
                        ${ vitals.vitalsDate }
                    </td>
                    <td>
                        ${ vitals.systolic }
                    </td>
                    <td>
                        ${ vitals.diatolic }
                    </td>
                    <td>
                        ${ vitals.pulse }
                    </td>
                    <td>
                        ${ vitals.comment }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="vitalsId" value="${ vitals.vitalsId }" />

    </fieldset>
</form>