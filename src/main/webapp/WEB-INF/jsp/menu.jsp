<%@ include file="/WEB-INF/include.jsp"%>

<ul id="mainmenu" class="list-unstyled">
	
	<sec:authorize access="!isAuthenticated()">
		<li><a href="<c:url value="/login" />">Login</a></li>
		<li><a class="list-group-item" href="<c:url value="/c3.html" />" >Graph</a></li>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<li><a class="list-group-item" href="<c:url value="/c3.html" />" >Graph</a></li>
		<li><a class="list-group-item" href="<c:url value="/activity/" />" >Activity List</a></li>
		<li><a class="list-group-item" href="<c:url value="/emailaddress/" />" >Email Address List</a></li>
		<li><a class="list-group-item" href="<c:url value="/person/" />" >Person List</a></li>
		<li><a class="list-group-item" href="<c:url value="/weight/" />" >Weight List</a></li>
		<li><a class="list-group-item" href="<c:url value="/vitals/" />" >Vitals List</a></li>
		<li><a class="list-group-item" href="<c:url value="/heartrate/" />" >Heart Rate List</a></li>
		<li><a class="list-group-item" href="<c:url value="/metric/" />" >Metrics List</a></li>
	
	</sec:authorize>
	
</ul>