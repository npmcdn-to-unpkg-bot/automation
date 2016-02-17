<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Metric List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>Metric Id</th>
            <th>Name</th>
            <th>Text Value</th>
            <th>Numeric Value</th>
            <th>Date Added</th>
            <th>Source</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ metricList }" var="metric"  varStatus="status">
            <tr>
                <td><a href="edit?metricId=${metric.metricId}">${metric.metricId}</a></td>
                <td>${metric.name}</td>
                <td>${metric.textValue}</td>
                <td>${metric.numericValue}</td>
                <td>${metric.dateAdded}</td>
                <td>${metric.source}</td>
                <td>
                    <a href="edit?metricId=${metric.metricId}">edit</a> 
                    <a href="show?metricId=${metric.metricId}">view</a>
                    <a href="delete?metricId=${metric.metricId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>