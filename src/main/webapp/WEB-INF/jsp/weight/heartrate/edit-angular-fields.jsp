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
   
    
        
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.value.$invalid && !resourceForm.value.$pristine }">
      <label for="value" class="control-label">Value</label>   
      <input type="text" id="value" ng-model="resource.value" name="value" required="" class="form-control"/>
      <p ng-show="resourceForm.value.$invalid && !resourceForm.value.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.measureDate.$invalid && !resourceForm.measureDate.$pristine }">
      <label for="measureDate" class="control-label">Measure Date</label>   
      <input type="text" id="measureDate" ng-model="resource.measureDate" name="measureDate" required="" class="form-control dateinput" data-provide="datepicker" data-date-format="yyyy-mm-dd" data-date-autoclose="true"/>
      <p ng-show="resourceForm.measureDate.$invalid && !resourceForm.measureDate.$pristine" class="help-block"> is required.</p>
    </div>
            
    
      
          
    <div class="form-group" ng-class="{ 'has-error' : resourceForm.personId.$invalid && !resourceForm.personId.$pristine }">
      <label for="personId" class="control-label">Person</label>
      <select ng-model="resource.person.personId" ng-options='o as o for o in  [<c:forEach var="x" items="${personList}" varStatus="loopStatus">${ x.personId }<c:if test="${!loopStatus.last}">,</c:if></c:forEach>]' required="" id="personId" name="personId" class="form-control">
	   <option value="">Select One</option>
	  </select>              
	  <p ng-show="resourceForm.personId.$invalid && !resourceForm.personId.$pristine" class="help-block"> is required.</p>		
	</div>		
        