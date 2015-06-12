var app = angular.module('app', [ 'ui.grid', 'ui.grid.resizeColumns', 'ui.grid.selection', 'ui.grid.autoResize','ui.grid.expandable']);

app.controller('SummaryTableCtrl', function ($scope, $http, uiGridConstants) {
	
	$scope.grid1={ showFooter: false,
			 enableHorizontalScrollbar : uiGridConstants.scrollbars.NEVER,
			 enableVerticalScrollbar : uiGridConstants.scrollbars.WHEN_NEEDED, 
			 enableColumnResizing : true, 
			 showGridFooter : false, 
			 showColumnFooter : false, 
			 enableSorting : true, 
			 enableFiltering : true,  
			 onRegisterApi : function( gridApi ) { $scope.vGrid = gridApi; }, 
			 columnDefs: [
							{ name: 'Date Instance', field: 'dateInstance', 
								width: '20%', sort: { direction: uiGridConstants.DESC, priority: 0} 
							},
	            			 
	            				 
							{ name: 'Weight Value', field: 'weightValue', width: '40%'  },
				            { name: 'Activity Value', field: 'activityValue', width: '40%'  }
				               
			]};
	
	  $http.get('./summary/').success(function(data) {
	    $scope.grid1.data = data.table;
	    
	  });

	  
	});

