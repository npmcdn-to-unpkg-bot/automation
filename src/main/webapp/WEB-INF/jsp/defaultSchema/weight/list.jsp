<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Weights</h2>

<c:url value="/weight/add" var="addUrl" />
<a href="${ addUrl }" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table id="weightTable" class="table table-bordered table-striped table-hover">
    <%-- table filled by setDataTable call below --%>
</table>

<c:url value="/weight/datatable" var="datatableUrl">
    <c:param name="display" value="list" />
</c:url>
<script type="text/javascript">
    var columns = [];
    columns.push({ "data": "urls", "name": "urls", "title":"", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "value", "name": "value", "title":"Value", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "weightInDate", "name": "weightInDate", "title":"Weight In Date", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "person", "name": "person", "title":"Person", "class":"", "sortable":false, "searchable": false });
    var table = setDataTable({
        id : 'weightTable',
        url : '${ datatableUrl }',
        columns : columns,
        individualSearching : true 
    });
</script>