<%@ include file="/WEB-INF/include.jsp"  %>
<div class="row">
  <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
<form:form method="post" commandName="emailAddress" action="save" role="form">
    <fieldset>
    <legend>EmailAddress</legend>

   
    
  	<form:hidden path="emailId" />
   
   
    
      <spring:bind path="address">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="address">Address</label>
	 	      <form:input path="address"  class="form-control"/>
	 	      <form:errors path="address" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="password">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="password">Password</label>
	 	      <form:password path="password"  class="form-control"/>
	 	      <form:errors path="password" class="help-block"/>
	     </div>
	</spring:bind>	
       <input type="submit" value="Save" class="btn btn-primary" />
    <a class="btn btn-default" href="list">Cancel</a>
    </fieldset>
</form:form>
</div>
</div>