var app = angular.module("my_req_3", []);

app.controller("req_3", function ($http, $scope){

    this.request = function add() {

        var indexTypeOfTourist = document.getElementById("Type").selectedIndex;
        var typeOfTourist = document.getElementById("Type").options[indexTypeOfTourist].innerHTML;

        $scope.tourists = [];
        $http.get('/tourists/getTouristByType?type_id=' + typeOfTourist).then(function (response){

            document.getElementById("Rez").innerText = " ";
            $scope.tourists = response.data;

            console.log($scope.tourists.length);

            if ($scope.tourists.length <= 0) {
                document.getElementById("Rez").innerText = "Даної інформації в базі не знайдено";
            }

        });

    };

});