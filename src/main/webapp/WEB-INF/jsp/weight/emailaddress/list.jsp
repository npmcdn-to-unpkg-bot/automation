<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Email Address List</h2>
<jsp:include page="/WEB-INF/jsp/angular-grid-rest-api.jsp" >
	<jsp:param name="restApiUrl" value="/rest"/>
	<jsp:param name="resourceName" value="emailaddress"/>
	<jsp:param name="resourceId" value="emailId"/>
</jsp:include>