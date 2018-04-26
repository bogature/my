var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.tourists = [];
    $http.get('/tourists/getAll').then(function (response) {
        $scope.tourists = response.data;
        //   console.log(response);
    });
    this.inserttourist = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var gender = document.getElementById("gender").value;
        var dateOfBirth = document.getElementById("dateOfBirth").value;
        var group = document.getElementById("group").value;
        var typeOfTourist = document.getElementById("typeOfTourist").value;
        var difficultyLevel = document.getElementById("difficultyLevel").value;
        var req = {
            method: 'POST',
            url: '/tourists/insert',
            data: {
                id: id,
                name: name,
                age: age,
                gender: gender,
                dateOfBirth: dateOfBirth,
                group: group.name,
                typeOfTourist: typeOfTourist,
                difficultyLevel: difficultyLevel
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

});

