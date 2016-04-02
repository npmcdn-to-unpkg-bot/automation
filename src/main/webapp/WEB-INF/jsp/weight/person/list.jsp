<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Persons</h2>


<jsp:include page="/WEB-INF/jsp/angular-grid-rest-api.jsp" ><jsp:param name="restApiUrl" value="/rest"/><jsp:param name="resourceName" value="person"/><jsp:param name="resourceId" value="personId"/></jsp:include>