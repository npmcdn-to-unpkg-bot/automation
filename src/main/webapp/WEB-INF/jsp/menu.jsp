<%@ include file="/WEB-INF/include.jsp"%>

<ul id="mainmenu" class="list-unstyled">
	
	<sec:authorize access="!isAuthenticated()">
		<li><a href="<c:url value="/login" />">Login</a></li>
	<li><a class="list-group-item" href="<c:url value="/activity/list" />" >Activity List</a></li>
	<li><a class="list-group-item" href="<c:url value="/emailaddress/list" />" >Email Address List</a></li>
	<li><a class="list-group-item" href="<c:url value="/person/list" />" >Person List</a></li>
	<li><a class="list-group-item" href="<c:url value="/weight/list" />" >Weight List</a></li>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
	</sec:authorize>
	
</ul>