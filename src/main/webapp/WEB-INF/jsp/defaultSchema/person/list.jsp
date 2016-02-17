<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Persons</h2>

<c:url value="/person/add" var="addUrl" />
<a href="${ addUrl }" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<table id="personTable" class="table table-bordered table-striped table-hover">
    <%-- table filled by setDataTable call below --%>
</table>

<c:url value="/person/datatable" var="datatableUrl">
    <c:param name="display" value="list" />
</c:url>
<script type="text/javascript">
    var columns = [];
    columns.push({ "data": "urls", "name": "urls", "title":"", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "password", "name": "password", "title":"Password", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "firstName", "name": "firstName", "title":"First Name", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "lastName", "name": "lastName", "title":"Last Name", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "middleName", "name": "middleName", "title":"Middle Name", "class":"", "sortable":true, "searchable": true });
    columns.push({ "data": "activitys", "name": "activitys", "title":"Activitys", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "vitalss", "name": "vitalss", "title":"Vitalss", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "weights", "name": "weights", "title":"Weights", "class":"", "sortable":false, "searchable": false });
    columns.push({ "data": "emailAddress", "name": "emailAddress", "title":"Email Address", "class":"", "sortable":false, "searchable": false });
    var table = setDataTable({
        id : 'personTable',
        url : '${ datatableUrl }',
        columns : columns,
        individualSearching : true 
    });
</script>