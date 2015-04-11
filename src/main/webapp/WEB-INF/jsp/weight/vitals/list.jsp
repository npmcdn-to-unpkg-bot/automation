<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Vitals List</h2>

<a href="add" class="btn btn-default">Add</a>

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
    columns.push({ "name": "urls", "title":"", "class":"", "sortable":false, "searchable": false });
    columns.push({ "name": "personId", "title":"PersonId",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "vitalsDate", "title":"VitalsDate",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "systolic", "title":"Systolic",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "diatolic", "title":"Diatolic",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "pulse", "title":"Pulse",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "comment", "title":"Comment",	"class":"", "sortable":true, "searchable": true });
    var table = setDataTable({
        id : 'vitalsTable',
        url : '${ datatableUrl }',
        columns : columns,
        individualSearching : true 
    });
</script>