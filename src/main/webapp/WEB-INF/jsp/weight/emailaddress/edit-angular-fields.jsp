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
   
    
        
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.address.$invalid && !resourceForm.address.$pristine }">
      <label for="address" class="control-label">Address</label>   
      <input type="text" id="address" ng-model="resource.address" name="address" required="" class="form-control"/>
      <p ng-show="resourceForm.address.$invalid && !resourceForm.address.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.password.$invalid && !resourceForm.password.$pristine }">
      <label for="password" class="control-label">Password</label>   
      <input type="text" id="password" ng-model="resource.password" name="password" required="" class="form-control"/>
      <p ng-show="resourceForm.password.$invalid && !resourceForm.password.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      