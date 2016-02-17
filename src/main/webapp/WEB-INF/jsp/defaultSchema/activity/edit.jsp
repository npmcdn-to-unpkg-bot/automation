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

<c:url value="/activity/save" var="formActionUrl" />
<c:url value="/activity/list" var="cancelUrl" />

<div class="row">
	<div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
		<form:form method="post" commandName="activity" action="${ formActionUrl }" role="form">
    		<fieldset>
    		
    			<legend>Activity</legend>
   
    
  				<form:hidden path="activityId" />
      
    
      			<spring:bind path="value">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="value" class="control-label">Value</label>
    					<form:input path="value"  class="form-control"/>
    				<form:errors path="value" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
      
    
      			<spring:bind path="activityDate">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="activityDate" class="control-label">Activity Date</label>
    					<form:input path="activityDate"  class="form-control dateinput" data-provide="datepicker" data-date-format="yyyy-mm-dd" data-date-autoclose="true"/>
    				<form:errors path="activityDate" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
        
    
      			<spring:bind path="person.personId">        
	     			<div class="form-group ${status.error ? 'has-error' : ''}">
	      				<label for="person.personId" class="control-label">Person</label>
    					<form:select path="person.personId" items="${personList}" itemValue="personId" itemLabel="personId" class="form-control"/>
					<form:errors path="person" class="help-block" element="span" />
    	     			</div>
				</spring:bind>	
       			
    			<input type="submit" value="Save" class="btn btn-primary" />
    			<a class="btn btn-default" href="${ cancelUrl }">Cancel</a>
    			
    		</fieldset>
		</form:form>
	</div>
</div>