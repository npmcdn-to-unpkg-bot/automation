<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Vitalss</h2>

<c:url value="/vitals/add" var="addUrl" />
<a href="${ addUrl }" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table id="vitalsTable" class="table table-bordered table-striped table-hover">
    <%-- table filled by setDataTable call below --%>
</table>

<c:url value="/vitals/datatable" var="datatableUrl">
    <c:param name="display" value="list" />
</c:url>
<script type="text/javascript">
    var columns = [];
    columns.push({ "data": "urls", "name": "urls", "title":"", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "vitalsDate", "name": "vitalsDate", "title":"Vitals Date", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "systolic", "name": "systolic", "title":"Systolic", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "diatolic", "name": "diatolic", "title":"Diatolic", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "pulse", "name": "pulse", "title":"Pulse", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "comment", "name": "comment", "title":"Comment", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "person", "name": "person", "title":"Person", "class":"", "sortable":false, "searchable": false });
    var table = setDataTable({
        id : 'vitalsTable',
        url : '${ datatableUrl }',
        columns : columns,
        individualSearching : true 
    });
</script>