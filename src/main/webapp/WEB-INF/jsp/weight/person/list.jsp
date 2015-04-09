<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Person List</h2>

<!-- <a href="add" class="btn btn-default">Add</a> -->

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
    columns.push({ "name": "urls", "title":"", "class":"", "sortable":false, "searchable": false });
    columns.push({ "name": "emailId", "title":"EmailId",	"class":"", "sortable":true, "searchable": true });
    //columns.push({ "name": "password", "title":"Password",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "firstName", "title":"FirstName",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "lastName", "title":"LastName",	"class":"", "sortable":true, "searchable": true });
    columns.push({ "name": "middleName", "title":"MiddleName",	"class":"", "sortable":true, "searchable": true });
    var table = setDataTable({
        id : 'personTable',
        url : '${ datatableUrl }',
        columns : columns,
        individualSearching : true 
    });
</script>