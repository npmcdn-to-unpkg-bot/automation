<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Metrics</h2>

<c:url value="/metric/add" var="addUrl" />
<a href="${ addUrl }" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table id="metricTable" class="table table-bordered table-striped table-hover">
    <%-- table filled by setDataTable call below --%>
</table>

<c:url value="/metric/datatable" var="datatableUrl">
    <c:param name="display" value="list" />
</c:url>
<script type="text/javascript">
    var columns = [];
    columns.push({ "data": "urls", "name": "urls", "title":"", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "name", "name": "name", "title":"Name", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "textValue", "name": "textValue", "title":"Text Value", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "numericValue", "name": "numericValue", "title":"Numeric Value", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "dateAdded", "name": "dateAdded", "title":"Date Added", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "source", "name": "source", "title":"Source", "class":"", "sortable":true, "searchable": true });
    var table = setDataTable({
        id : 'metricTable',
        url : '${ datatableUrl }',
        columns : columns,
        individualSearching : true 
    });
</script>