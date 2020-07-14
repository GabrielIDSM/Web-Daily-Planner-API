webdailyplanner.controller("usuarioController", function ($scope, $http) {
    $scope.usuarioCad = {};
    $scope.usuarioLogin = {};
    $scope.cadastraNovoUsuario = function  (){
        $http({method: 'POST', url: 'http://localhost:8080/usuarios', data:$scope.usuarioCad}).then(function (response) {
            console.log(response.status);
        }, function (response) {
            console.log(response.status);
        });
    };
    $scope.verificaUsuario = function  (){
        $http({method: 'POST', url: 'http://localhost:8080/usuarios/login', data:$scope.usuarioLogin}).then(function (response) {
            console.log(response.status);
        }, function (response) {
            console.log(response.status);
        });
    };
});