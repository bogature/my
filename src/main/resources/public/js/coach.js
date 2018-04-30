var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.instructors = [];
    $http.get('/instructors/getAll').then(function (response) {
        $scope.instructors = response.data;
        //   console.log(response);
    });

    this.beforeInsert = function () {
        $http.get('/instructors/getAll').then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("section");
            $(selector).empty();
            for (var i = 0; instructors.length; i++) {
                var option = document.createElement("option");
                option.text = instructors[i].name;
                option.value = instructors[i].id;
                selector.add(option);
            }
        });
        $http.get('/loadLevels/getAll').then(function (response) {
            var loadLevels = response.data;
            var selector = document.getElementById("loadLevel");
            $(selector).empty();
            for (var i = 0; loadLevels.length; i++) {
                var option = document.createElement("option");
                option.text = loadLevels[i].name;
                option.value = loadLevels[i].id;
                selector.add(option);
            }
        });
    };

    this.insertCoach = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var salary = document.getElementById("salary").value;
        var section = document.getElementById("section").value;
        var loadLevel = document.getElementById("loadLevel").value;
        var req = {
            method: 'POST',
            url: '/instructors/insert',
            data: {
                name: name,
                age: age,
                salary: salary,
                section: section,
                loadLevel: loadLevel
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

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

