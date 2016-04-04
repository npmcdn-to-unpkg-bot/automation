<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Vitals List</h2>

<jsp:include page="/WEB-INF/jsp/angular-grid-rest-api.jsp" ><jsp:param name="restApiUrl" value="/rest"/><jsp:param name="resourceName" value="vitals"/><jsp:param name="resourceId" value="vitalsId"/></jsp:include>