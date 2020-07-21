webdailyplanner.controller("usuarioController", function ($scope, $rootScope, $http, $location) {
    $scope.usuarioCad = {};
    $rootScope.usuarioLogin = {};
    $scope.cadastraNovoUsuario = function  (){
        $http({method: 'POST', url: 'http://localhost:8080/usuarios', data:$scope.usuarioCad}).then(function (response) {
            console.log(response.status);
        }, function (response) {
            console.log(response.status);
        });
    };
    $scope.verificaUsuario = function  (){
        $http({method: 'POST', url: 'http://localhost:8080/usuarios/login', data:$rootScope.usuarioLogin}).then(function (response) {
            $location.path('/calendario');
        }, function (response) {
            console.log(response.status);
        });
    };
});