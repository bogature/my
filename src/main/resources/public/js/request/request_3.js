var app = angular.module("my_req_3", []);

app.controller("req_3", function ($http, $scope){

    this.request = function add() {

        var indexOfType = document.getElementById("Type").selectedIndex;
        type_id = document.getElementById("Type").options[indexOfGroup].value;

        $scope.tourists = [];
        $http.get('/tourists/getTouristByType?type_id=' + type_id).then(function (response){

            document.getElementById("Rez").innerText = " ";
            $scope.tourists = response.data;

            console.log($scope.tourists.length);

            if ($scope.tourists.length <= 0) {
                document.getElementById("Rez").innerText = "Даної інформації в базі не знайдено";
            }

        });

    };

});