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
   
    
        
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.name.$invalid && !resourceForm.name.$pristine }">
      <label for="name" class="control-label">Name</label>   
      <input type="text" id="name" ng-model="resource.name" name="name" required="" class="form-control"/>
      <p ng-show="resourceForm.name.$invalid && !resourceForm.name.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.textValue.$invalid && !resourceForm.textValue.$pristine }">
      <label for="textValue" class="control-label">Text Value</label>   
      <input type="text" id="textValue" ng-model="resource.textValue" name="textValue" required="" class="form-control"/>
      <p ng-show="resourceForm.textValue.$invalid && !resourceForm.textValue.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.numericValue.$invalid && !resourceForm.numericValue.$pristine }">
      <label for="numericValue" class="control-label">Numeric Value</label>   
      <input type="text" id="numericValue" ng-model="resource.numericValue" name="numericValue" required="" class="form-control"/>
      <p ng-show="resourceForm.numericValue.$invalid && !resourceForm.numericValue.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.dateAdded.$invalid && !resourceForm.dateAdded.$pristine }">
      <label for="dateAdded" class="control-label">Date Added</label>   
      <input type="text" id="dateAdded" ng-model="resource.dateAdded" name="dateAdded" required="" class="form-control dateinput" data-provide="datepicker" data-date-format="yyyy-mm-dd" data-date-autoclose="true"/>
      <p ng-show="resourceForm.dateAdded.$invalid && !resourceForm.dateAdded.$pristine" class="help-block"> is required.</p>
    </div>
          
    
      
        <div class="form-group" ng-class="{ 'has-error' : resourceForm.source.$invalid && !resourceForm.source.$pristine }">
      <label for="source" class="control-label">Source</label>   
      <input type="text" id="source" ng-model="resource.source" name="source" required="" class="form-control"/>
      <p ng-show="resourceForm.source.$invalid && !resourceForm.source.$pristine" class="help-block"> is required.</p>
    </div>
        