var app = angular.module("my_req_4", []);

app.controller("req_4", function ($http, $scope){

    this.request = function add() {

        console.log("start");

        var age = document.getElementById("Аge").value;

        $http.get('/tourists/getCountTouristByAge?age=' + age).then(function (response){

            console.log(response.data);
            document.getElementById("Rez").innerText = response.data;

        });

    };

});