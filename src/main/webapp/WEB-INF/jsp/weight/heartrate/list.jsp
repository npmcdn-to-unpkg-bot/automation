<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Heart Rate</h2>

<div id="error_div" class="alert alert-error" style="display: none;">
    <%-- div for showing errors, see messager.js.showMessage --%>
</div>

<jsp:include page="/WEB-INF/jsp/angular-grid-rest-api.jsp" >
	<jsp:param name="restApiUrl" value="/rest"/>
	<jsp:param name="resourceName" value="heartrate"/>
	<jsp:param name="resourceId" value="heartRateId"/>
</jsp:include>