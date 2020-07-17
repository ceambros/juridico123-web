myApp.controller('MenuController', ['$scope', '$http', function($scope, $http){
	
	$scope.menus = [];

	$http.get('../../resources/script/json/menus.json')
	.success(function(response){
		$scope.menus = response.menu1;
	})
	.error(function(error){
		console.log(error);
	});

}]);