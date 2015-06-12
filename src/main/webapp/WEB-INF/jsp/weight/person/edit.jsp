<%@ include file="/WEB-INF/include.jsp"  %>
<div class="row">
  <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
<form:form method="post" commandName="person" action="save" role="form">
    <fieldset>
    <legend>Person</legend>

   
    
  	<form:hidden path="personId" />
   
   
    
      <spring:bind path="emailId">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="emailId">EmailId</label>
	 	      <form:input path="emailId"  class="form-control"/>
	 	      <form:errors path="emailId" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="password">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="password">Password</label>
	 	      <form:password path="password"  class="form-control"/>
	 	      <form:errors path="password" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="firstName">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="firstName">FirstName</label>
	 	      <form:input path="firstName"  class="form-control"/>
	 	      <form:errors path="firstName" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="lastName">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="lastName">LastName</label>
	 	      <form:input path="lastName"  class="form-control"/>
	 	      <form:errors path="lastName" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="middleName">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="middleName">MiddleName</label>
	 	      <form:input path="middleName"  class="form-control"/>
	 	      <form:errors path="middleName" class="help-block"/>
	     </div>
	</spring:bind>	
       <input type="submit" value="Save" class="btn btn-primary" />
    <a class="btn btn-default" href="list">Cancel</a>
    </fieldset>
</form:form>
</div>
</div>