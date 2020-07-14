webdailyplanner.controller("calendarioController", function ($scope, $http) {
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
});

