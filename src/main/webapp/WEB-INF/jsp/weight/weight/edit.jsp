<%@ include file="/WEB-INF/include.jsp"  %>
<div class="row">
  <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
<form:form method="post" commandName="weight" action="save" role="form">
    <fieldset>
    <legend>Weight</legend>

   
    
  	<form:hidden path="weightId" />
   
   
    
      <spring:bind path="personId">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="personId">PersonId</label>
	 	      <form:input path="personId"  class="form-control"/>
	 	      <form:errors path="personId" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="value">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="value">Value</label>
	 	      <form:input path="value"  class="form-control"/>
	 	      <form:errors path="value" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="weightInDate">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="weightInDate">WeightInDate</label>
	 	      <form:input path="weightInDate"  class="form-control dateinput "/>
	 	      <form:errors path="weightInDate" class="help-block"/>
	     </div>
	</spring:bind>	
       <input type="submit" value="Save" class="btn btn-primary" />
    <a class="btn btn-default" href="list">Cancel</a>
    </fieldset>
</form:form>
</div>
</div>