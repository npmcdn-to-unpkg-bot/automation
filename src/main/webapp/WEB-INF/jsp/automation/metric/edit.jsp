<%--
  #%L
  Protogen
  %%
  Copyright (C) 2009 - 2015 University of Iowa Institute for Clinical and Translational Science (ICTS)
  %%
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  
       http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  #L%
  --%>
<%@ include file="/WEB-INF/include.jsp"  %>

<c:url value="/metric/save" var="formActionUrl" />
<c:url value="/metric/list" var="cancelUrl" />

<div class="row">
	<div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
		<form:form method="post" commandName="metric" action="${ formActionUrl }" role="form">
    		<fieldset>
    		
    			<legend>Metric</legend>
   
    
  				<form:hidden path="metricId" />
      
    
      			<spring:bind path="name">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="name" class="control-label">Name</label>
    					<form:input path="name"  class="form-control"/>
    				<form:errors path="name" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
      
    
      			<spring:bind path="textValue">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="textValue" class="control-label">Text Value</label>
    					<form:input path="textValue"  class="form-control"/>
    				<form:errors path="textValue" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
      
    
      			<spring:bind path="numericValue">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="numericValue" class="control-label">Numeric Value</label>
    					<form:input path="numericValue"  class="form-control"/>
    				<form:errors path="numericValue" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
      
    
      			<spring:bind path="dateAdded">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="dateAdded" class="control-label">Date Added</label>
    					<form:input path="dateAdded"  class="form-control dateinput" data-provide="datepicker" data-date-format="yyyy-mm-dd" data-date-autoclose="true"/>
    				<form:errors path="dateAdded" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
      
    
      			<spring:bind path="source">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="source" class="control-label">Source</label>
    					<form:input path="source"  class="form-control"/>
    				<form:errors path="source" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
       			
    			<input type="submit" value="Save" class="btn btn-primary" />
    			<a class="btn btn-default" href="${ cancelUrl }">Cancel</a>
    			
    		</fieldset>
		</form:form>
	</div>
</div>