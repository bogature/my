var app = angular.module("my_req_6", []);

app.controller("req_6", function ($http, $scope){

    this.request = function add() {

        var indexTypeOfTourist = document.getElementById("Type").selectedIndex;
        var typeOfTourist = document.getElementById("Type").options[indexTypeOfTourist].innerHTML;

        $scope.tourists = [];
        $http.get('/tourists/getCountTouristByType?type_id=' + typeOfTourist).then(function (response){

            console.log(response.data);
            document.getElementById("Rez").innerText = response.data;

        });

    };

});
