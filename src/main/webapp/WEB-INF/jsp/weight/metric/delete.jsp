<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Metric</h2>

<c:url value="/metric/delete" var="formActionUrl" />

<form:form method="post" action="${ formActionUrl }">
    <fieldset>
        <legend>Are you sure you want to delete this metric?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Metric Id</th>
                    <th>Name</th>
                    <th>Text Value</th>
                    <th>Numeric Value</th>
                    <th>Date Added</th>
                    <th>Source</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ metric.metricId }
                    </td>
                    <td>
                        ${ metric.name }
                    </td>
                    <td>
                        ${ metric.textValue }
                    </td>
                    <td>
                        ${ metric.numericValue }
                    </td>
                    <td>
                        ${ metric.dateAdded }
                    </td>
                    <td>
                        ${ metric.source }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="metricId" value="${ metric.metricId }" />

    </fieldset>
</form:form>