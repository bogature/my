var app = angular.module("my_req_5", []);

app.controller("req_5", function ($http, $scope){

    this.request = function add() {

        var age = document.getElementById("Аge").value;

        $scope.tourists = [];
        $http.get('/tourists/getTouristByAge?age=' + age).then(function (response){

            document.getElementById("Rez").innerText = " ";
            $scope.tourists = response.data;

            if ($scope.tourists.length <= 0) {
                document.getElementById("Rez").innerText = "Даної інформації в базі не знайдено";
            }

        });

    };

});