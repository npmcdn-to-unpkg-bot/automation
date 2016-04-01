<%@ include file="/WEB-INF/include.jsp"  %>

<!-- Start: Angular Grid prototype (Requires REST API) -->
<div ng-controller="GridController" id="gridParent">
  <div class="panel panel-default">
	  <div class="panel-heading">
	  	<button type="button" class="btn btn-primary" ng-click="addRow()">Add ${param.resourceName}</button>
		<button type="button" class="btn btn-primary" ng-click="deleteSelected()">Delete Selected ${param.resourceName}</button>
	  </div>
      <div class="panel-body alert" ng-show="alertMessage" ng-class="{ 'alert-success' : resourceSuccessful, 'alert-danger' : !resourceSuccessful }" role="alert">{{alertMessage}}</div>
  </div>	
  <div id="gridId" ui-grid="gridModel" ui-grid-edit ui-grid-auto-resize ui-grid-selection external-scopes="$scope" ng-style="getTableHeight()"></div>
</div>
<script>
var app = angular.module('gridDisplay', ['ngResource', 'ui.grid','ui.grid.resizeColumns', 'ui.grid.selection', 'ui.grid.autoResize','ui.grid.expandable', 'ui.grid.edit'])
				 .controller('GridController', ['$scope', '$resource', 'uiGridConstants',  function ($scope, $resource, uiGridConstants) {
	
	var ResourceService = $resource('<c:url value="${param.restApiUrl}/${param.resourceName}/:id" />',  { id: '@${param.resourceId}' });
	// how to load an individual object by id...
/* 	ResourceService.get({id:41}, function(${param.resourceName}) {
		console.log(${param.resourceName});
	}); */
	// define grid
	$scope.gridModel = { enableFiltering: true, enableColumnResizing: true, showColumnFooter: true , showGridFooter: true, enableRowHeaderSelection: false};
	// load data into Grid
	$scope.gridModel.data = ResourceService.query();
	// update data inline
	$scope.gridModel.onRegisterApi = function(gridApi){
        //set gridApi on scope
        $scope.gridApi = gridApi;
        gridApi.edit.on.afterCellEdit($scope,function(rowEntity, colDef, newValue, oldValue){
          rowEntity.$save(function() { 
  			// reload data into Grid
  			$scope.gridModel.data = ResourceService.query();
  			$scope.alertMessage = "Row successfully saved.";
  	        $scope.resourceSuccessful = true;
  	      }, function(error) {
  	        $scope.alertMessage = error.data.message;
  	        $scope.resourceSuccessful = false;
  	      });
        });
      };
    // add a row
    $scope.addRow = function() {
    	$scope.gridModel.data.push(new ResourceService());
   	};  
    // delete selected rows
    $scope.deleteSelected = function() {
	    var rows = $scope.gridApi.selection.getSelectedRows($scope.gridModel);
	    for (var x=0;x<rows.length;x++) {
	  		rows[x].$delete(function() { 
	  			// reload data into Grid
	  			$scope.gridModel.data = ResourceService.query();
	  			$scope.alertMessage = "Row successfully deleted.";
	  	        $scope.resourceSuccessful = true;
	  		}, function(error) {
	  	        $scope.alertMessage = error.data.message;
	  	        $scope.resourceSuccessful = false;
	  	    });
	  	}
  	};
  	// dynyamically change grid height relative to window height
  	$scope.getTableHeight = function() {
        return {
           height: ($(window).height() - $("#gridId").offset().top - $( "#footer" ).height() - 60 - 16) + "px"
        };
     };
}]);
angular.bootstrap(document, ['gridDisplay']);
</script>
<!-- End: Angular Grid prototype -->