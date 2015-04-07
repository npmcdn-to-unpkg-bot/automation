<%@page import="java.io.*"%>

<% Throwable e = (Throwable) request.getAttribute( "javax.servlet.error.exception" ); %>

<h2>
	<span class="jira-error-summary">Error while processing page <%= request.getAttribute( "javax.servlet.error.request_uri" ) %></span>
	<br/>
	<small class="jira-error-description"><% out.print( e.getMessage() ); %></small>
</h2>

<%-- <a href="#" class="jiraButton btn btn-danger hidden-phone">Report Error</a> --%>
<button id="button" class="btn btn-danger" onclick="$('#details').show(); $('#button').hide();">details</button>

<div id="details" style="display: none; margin-top: 15px;">
<pre>
<%
	Writer result = new StringWriter();
	PrintWriter printWriter = new PrintWriter( result );
	e.printStackTrace( printWriter );
	out.print( result.toString() );
%>
</pre>
</div>