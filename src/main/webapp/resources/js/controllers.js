var app = angular.module('app', [ 'ui.grid']);

app.controller('SummaryTableCtrl', function ($scope, $http) {
	  $http.get('./summary/').success(function(data) {
	    $scope.data = data.table;
	  });

	  
	});

