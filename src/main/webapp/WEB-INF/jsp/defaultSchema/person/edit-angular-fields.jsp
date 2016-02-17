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
   
    
        
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.password.$invalid && !resourceForm.password.$pristine }">
      <label for="password" class="control-label">Password</label>   
      <input type="text" id="password" ng-model="resource.password" name="password" required="" class="form-control"/>
      <p ng-show="resourceForm.password.$invalid && !resourceForm.password.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.firstName.$invalid && !resourceForm.firstName.$pristine }">
      <label for="firstName" class="control-label">First Name</label>   
      <input type="text" id="firstName" ng-model="resource.firstName" name="firstName" required="" class="form-control"/>
      <p ng-show="resourceForm.firstName.$invalid && !resourceForm.firstName.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.lastName.$invalid && !resourceForm.lastName.$pristine }">
      <label for="lastName" class="control-label">Last Name</label>   
      <input type="text" id="lastName" ng-model="resource.lastName" name="lastName" required="" class="form-control"/>
      <p ng-show="resourceForm.lastName.$invalid && !resourceForm.lastName.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.middleName.$invalid && !resourceForm.middleName.$pristine }">
      <label for="middleName" class="control-label">Middle Name</label>   
      <input type="text" id="middleName" ng-model="resource.middleName" name="middleName" required="" class="form-control"/>
      <p ng-show="resourceForm.middleName.$invalid && !resourceForm.middleName.$pristine" class="help-block"> is required.</p>
    </div>
          
    
        
    
        
    
          
    
      
          
    <div class="form-group" ng-class="{ 'has-error' : resourceForm.emailId.$invalid && !resourceForm.emailId.$pristine }">
      <label for="emailId" class="control-label">Email Address</label>
      <select ng-model="resource.emailAddress.emailId" ng-options='o as o for o in  [<c:forEach var="x" items="${emailAddressList}" varStatus="loopStatus">${ x.emailId }<c:if test="${!loopStatus.last}">,</c:if></c:forEach>]' required="" id="emailId" name="emailId" class="form-control">
	   <option value="">Select One</option>
	  </select>              
	  <p ng-show="resourceForm.emailId.$invalid && !resourceForm.emailId.$pristine" class="help-block"> is required.</p>		
	</div>		
        