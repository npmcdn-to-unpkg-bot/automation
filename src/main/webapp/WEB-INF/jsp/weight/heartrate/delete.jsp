<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Heart Rate</h2>

<c:url value="/heartrate/delete" var="formActionUrl" />

<form:form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this heart rate?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Heart Rate Id</th>
                    <th>Value</th>
                    <th>Measure Date</th>
                    <th>Person</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ heartRate.heartRateId }
                    </td>
                    <td>
                        ${ heartRate.value }
                    </td>
                    <td>
                        ${ heartRate.measureDate }
                    </td>
                    <td>
                        ${ heartRate.person }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="heartRateId" value="${ heartRate.heartRateId }" />

    </fieldset>
</form:form>