var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.managers = [];
    $http.get('/managers/getAll').then(function (response) {
        $scope.managers = response.data;
        //   console.log(response);
    });


    this.insertManager = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var dateOfBirth = document.getElementById("dateOfBirth").value;
        var experience = document.getElementById("experience").value;
        var req = {
            method: 'POST',
            url: '/managers/insert',
            data: {
                name: name,
                age: age,
                dateOfBirth: dateOfBirth,
                experience: experience
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.beforeUpdate = function (id, name, age, dateOfBirth, experience) {
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        document.getElementById("ageUPD").value = age;
        document.getElementById("dateOfBirthUPD").value = dateOfBirth;
        document.getElementById("experienceUPD").value = experience;
    };

    this.updateManager = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var age = document.getElementById("ageUPD").value;
        var dateOfBirth = document.getElementById("dateOfBirthUPD").value;
        var experience = document.getElementById("experienceUPD").value;
        var req = {
            method: 'POST',
            url: '/managers/update?id=' + id,
            data: {
                name: name,
                age: age,
                dateOfBirth: dateOfBirth,
                experience: experience
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.deleteManager = function (id) {
        $http.delete('managers/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});


