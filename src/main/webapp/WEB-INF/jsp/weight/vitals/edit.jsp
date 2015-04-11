<%@ include file="/WEB-INF/include.jsp"  %>
<div class="row">
  <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
<form:form method="post" commandName="vitals" action="save" role="form">
    <fieldset>
    <legend>Vitals</legend>

   
    
  	<form:hidden path="vitalsId" />
   
   
    
      <spring:bind path="personId">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="personId">PersonId</label>
	 	      <form:input path="personId"  class="form-control"/>
	 	      <form:errors path="personId" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="vitalsDate">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="vitalsDate">VitalsDate</label>
	 	      <form:input path="vitalsDate"  class="form-control dateinput "/>
	 	      <form:errors path="vitalsDate" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="systolic">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="systolic">Systolic</label>
	 	      <form:input path="systolic"  class="form-control"/>
	 	      <form:errors path="systolic" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="diatolic">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="diatolic">Diatolic</label>
	 	      <form:input path="diatolic"  class="form-control"/>
	 	      <form:errors path="diatolic" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="pulse">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="pulse">Pulse</label>
	 	      <form:input path="pulse"  class="form-control"/>
	 	      <form:errors path="pulse" class="help-block"/>
	     </div>
	</spring:bind>	
   
   
    
      <spring:bind path="comment">        
	     <div class="form-group ${status.error ? 'has-error' : ''}">
	      <label for="comment">Comment</label>
	 	      <form:input path="comment"  class="form-control"/>
	 	      <form:errors path="comment" class="help-block"/>
	     </div>
	</spring:bind>	
       <input type="submit" value="Save" class="btn btn-primary" />
    <a class="btn btn-default" href="list">Cancel</a>
    </fieldset>
</form:form>
</div>
</div>