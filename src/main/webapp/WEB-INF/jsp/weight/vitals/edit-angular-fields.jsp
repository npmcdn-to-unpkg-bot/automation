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
   
    
        
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.vitalsDate.$invalid && !resourceForm.vitalsDate.$pristine }">
      <label for="vitalsDate" class="control-label">Vitals Date</label>   
      <input type="text" id="vitalsDate" ng-model="resource.vitalsDate" name="vitalsDate" required="" class="form-control dateinput" data-provide="datepicker" data-date-format="yyyy-mm-dd" data-date-autoclose="true"/>
      <p ng-show="resourceForm.vitalsDate.$invalid && !resourceForm.vitalsDate.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.systolic.$invalid && !resourceForm.systolic.$pristine }">
      <label for="systolic" class="control-label">Systolic</label>   
      <input type="text" id="systolic" ng-model="resource.systolic" name="systolic" required="" class="form-control"/>
      <p ng-show="resourceForm.systolic.$invalid && !resourceForm.systolic.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.diatolic.$invalid && !resourceForm.diatolic.$pristine }">
      <label for="diatolic" class="control-label">Diatolic</label>   
      <input type="text" id="diatolic" ng-model="resource.diatolic" name="diatolic" required="" class="form-control"/>
      <p ng-show="resourceForm.diatolic.$invalid && !resourceForm.diatolic.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.pulse.$invalid && !resourceForm.pulse.$pristine }">
      <label for="pulse" class="control-label">Pulse</label>   
      <input type="text" id="pulse" ng-model="resource.pulse" name="pulse" required="" class="form-control"/>
      <p ng-show="resourceForm.pulse.$invalid && !resourceForm.pulse.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.comment.$invalid && !resourceForm.comment.$pristine }">
      <label for="comment" class="control-label">Comment</label>   
      <input type="text" id="comment" ng-model="resource.comment" name="comment" required="" class="form-control"/>
      <p ng-show="resourceForm.comment.$invalid && !resourceForm.comment.$pristine" class="help-block"> is required.</p>
    </div>
            
    
      
          
    <div class="form-group" ng-class="{ 'has-error' : resourceForm.personId.$invalid && !resourceForm.personId.$pristine }">
      <label for="personId" class="control-label">Person</label>
      <select ng-model="resource.person.personId" ng-options='o as o for o in  [<c:forEach var="x" items="${personList}" varStatus="loopStatus">${ x.personId }<c:if test="${!loopStatus.last}">,</c:if></c:forEach>]' required="" id="personId" name="personId" class="form-control">
	   <option value="">Select One</option>
	  </select>              
	  <p ng-show="resourceForm.personId.$invalid && !resourceForm.personId.$pristine" class="help-block"> is required.</p>		
	</div>		
        