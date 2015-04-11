<%@ include file="/WEB-INF/include.jsp"  %>

<div id="mainmenu" class="list-group">
	<a class="list-group-item" href="<c:url value="/activity/list" />" >Activity List</a>
	<a class="list-group-item" href="<c:url value="/emailaddress/list" />" >EmailAddress List</a>
	<a class="list-group-item" href="<c:url value="/person/list" />" >Person List</a>
	<a class="list-group-item" href="<c:url value="/vitals/list" />" >Vitals List</a>
	<a class="list-group-item" href="<c:url value="/weight/list" />" >Weight List</a>
</div>
