var app = angular.module("userSection", []);

app.controller ("AppCtrl", function($scope, $http){
	$scope.websites = [];
	$http.get("http://localhost:8080/table").then(function (response){
		var data = response.data;
		$scope.websites = data;
	});
});
