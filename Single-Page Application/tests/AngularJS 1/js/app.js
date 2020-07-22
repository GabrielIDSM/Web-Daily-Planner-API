//Criacao do Modulo principal
var webdailyplanner = angular.module("webdailyplanner", ['ngRoute']);

//Criação de rotas
webdailyplanner.config(function ($routeProvider){
    $routeProvider
    .when('/usuario', {
        templateUrl: 'html/usuario.html',
        controller: 'usuarioController'})
    .when('/calendario', {
        templateUrl: 'html/calendario.html',
        controller: 'calendarioController'})
    .when('/evento', {
        templateUrl: 'html/evento.html',
        controller: 'eventoController'})
    .otherwise({redirectTo:'/'});
});

webdailyplanner.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');
  $locationProvider.html5Mode(true);
}]);