webdailyplanner.controller("calendarioController", function ($scope, $http, $rootScope, $location) {
    $scope.calendario;
    $scope.defineCalendario = function () {
        $http({method: 'GET', url: 'http://localhost:8080/calendario'}).then(function (response) {
            $scope.calendario = response.data;
            console.log(response.data);
            console.log(response.status);
        }, function (response) {
            console.log(response.status);
        });
    };
    $scope.listaEventos = function () {
        $http({method: 'POST', url: 'http://localhost:8080/dia', data: $scope.usuarioLogin}).then(function (response) {
            $scope.calendario = response.data;
            console.log(response.data);
            console.log(response.status);
        }, function (response) {
            console.log(response.status);
        });
    };
    $scope.listaEventos();
    $scope.verificaUsuarioNovoEvento = function  (){
        $http({method: 'POST', url: 'http://localhost:8080/usuarios/login', data:$rootScope.usuarioLogin}).then(function (response) {
            $location.path('/evento');
        }, function (response) {
            console.log(response.status);
        });
    };
});

