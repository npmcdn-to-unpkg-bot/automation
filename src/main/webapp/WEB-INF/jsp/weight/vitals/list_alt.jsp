<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Vitals List</h2>

<a href="add" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table class="table table-bordered table-striped table-hover table-datatable">
    <thead>
        <tr>
            <th>VitalsId</th>
            <th>Person</th>
            <th>VitalsDate</th>
            <th>Systolic</th>
            <th>Diatolic</th>
            <th>Pulse</th>
            <th>Comment</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${vitalsList}" var="vitals"  varStatus="status">
            <tr>
                <td><a href="edit?vitalsId=${vitals.vitalsId}">${vitals.vitalsId}</a></td>
                <td>${vitals.personName}</td>
                <td>${vitals.vitalsDate}</td>
                <td>${vitals.systolic}</td>
                <td>${vitals.diatolic}</td>
                <td>${vitals.pulse}</td>
                <td>${vitals.comment}</td>
                <td>
                    <a href="edit?vitalsId=${vitals.vitalsId}">edit</a> 
                    <a href="show?vitalsId=${vitals.vitalsId}">view</a>
                    <a href="delete?vitalsId=${vitals.vitalsId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>