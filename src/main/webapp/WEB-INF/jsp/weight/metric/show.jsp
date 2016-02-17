<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Metric</h2>

<h2> ${metric.metricId} </h2>

<table class="table table-bordered table-hover">
    <tr>
        <th>Metric Id</th>
        <td>
            ${metric.metricId}
        </td>
    </tr>
    <tr>
        <th>Name</th>
        <td>
            ${metric.name}
        </td>
    </tr>
    <tr>
        <th>Text Value</th>
        <td>
            ${metric.textValue}
        </td>
    </tr>
    <tr>
        <th>Numeric Value</th>
        <td>
            ${metric.numericValue}
        </td>
    </tr>
    <tr>
        <th>Date Added</th>
        <td>
            ${metric.dateAdded}
        </td>
    </tr>
    <tr>
        <th>Source</th>
        <td>
            ${metric.source}
        </td>
    </tr>
</table>