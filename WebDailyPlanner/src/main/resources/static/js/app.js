//Criacao do Modulo principal
var webdailyplanner = angular.module("webdailyplanner", ['ngRoute']);

//Criação de rotas
webdailyplanner.config(function ($routeProvider){
    $routeProvider
    .when('/usuarios', {
        templateUrl: 'html/usuario.html',
        controller: 'usuarioController'})
    .otherwise({redirectTo:'/'});
});

webdailyplanner.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
}]);