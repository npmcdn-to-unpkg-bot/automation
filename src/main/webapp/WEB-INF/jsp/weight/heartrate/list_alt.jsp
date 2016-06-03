<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Heart Rate List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>Heart Rate Id</th>
            <th>Value</th>
            <th>Measure Date</th>
            <th>Person</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ heartRateList }" var="heartRate"  varStatus="status">
            <tr>
                <td><a href="edit?heartRateId=${heartRate.heartRateId}">${heartRate.heartRateId}</a></td>
                <td>${heartRate.value}</td>
                <td>${heartRate.measureDate}</td>
                <td>${heartRate.person.personId}</td>
                <td>
                    <a href="edit?heartRateId=${heartRate.heartRateId}">edit</a> 
                    <a href="show?heartRateId=${heartRate.heartRateId}">view</a>
                    <a href="delete?heartRateId=${heartRate.heartRateId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>