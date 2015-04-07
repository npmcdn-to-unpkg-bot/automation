<%@ include file="/WEB-INF/include.jsp"%>

<h1>${ empty headerText ? 'Application Message' : headerText }</h1>

<div class="well">
	<div class="alert ${ error eq true ? 'alert-error' : '' }">
		<span class="lead">${ message }</span>
	</div>
</div>