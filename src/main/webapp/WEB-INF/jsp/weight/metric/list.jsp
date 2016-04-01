<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Metrics</h2>

<c:url value="/metric/add" var="addUrl" />
<a href="${ addUrl }" class="btn btn-default">Add</a>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<jsp:include page="/WEB-INF/jsp/angular-grid-rest-api.jsp" ><jsp:param name="restApiUrl" value="/rest"/><jsp:param name="resourceName" value="metric"/><jsp:param name="resourceId" value="metricId"/></jsp:include>