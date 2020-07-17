var myDirectives = angular.module('minhasDiretivas',[]);

myDirectives.directive('meuPainel', function(){

	var ddo = {};

	//pode ser usado como attributo ou elemento
	ddo.restric = "AE";

	ddo.scope = {
		descricao : '@',
		url: '@'
	};

	//mantem os elementos internos e add onde tiver 'ng-transclude' no template
	ddo.transclude = true;

	ddo.templateUrl = '../../resources/script/directives/meu-painel.html';

	return ddo;

});