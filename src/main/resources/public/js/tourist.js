var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.tourists = [];
    $http.get('/tourists/getAll').then(function (response) {
        $scope.tourists = response.data;
        //   console.log(response);
    });

    this.beforeInsert = function () {
        $http.get('/groups/getAll').then(function (response) {
            var groups = response.data;
            var selector = document.getElementById("groups");
            $(selector).empty();
            for (var i = 0; i < groups.length; i++) {
                var option = document.createElement("option");
                option.text = groups[i].name;
                option.value = groups[i].id;
                selector.add(option);
            }
        });
    };

    this.insertTourist = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var indexGender = document.getElementById("gender").selectedIndex;
        var gender = document.getElementById("gender").options[indexGender].innerHTML;
        var dateOfBirth = document.getElementById("dateOfBirth").value;
        var indexGroup = document.getElementById("groups").selectedIndex;
        var groupId = document.getElementById("groups").options[indexGroup].value;
        var indexDifficultyLevel = document.getElementById("difficultyLevel").selectedIndex;
        var difficultyLevel = document.getElementById("difficultyLevel").options[indexDifficultyLevel].innerHTML;
        var indexTypeOfTourist = document.getElementById("typeOfTourist").selectedIndex;
        var typeOfTourist = document.getElementById("typeOfTourist").options[indexTypeOfTourist].innerHTML;
        $http.get('/groups/getById?id='+groupId).then(function (response) {
            var selectedGroup = response.data;
            var req = {
                method: 'POST',
                url: '/tourists/insert',
                data: {
                    name: name,
                    age: age,
                    gender: gender,
                    dataOfBirth: dateOfBirth,
                    groups: selectedGroup,
                    difficultyLevel: difficultyLevel,
                    typeOfTourist: typeOfTourist
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
    };

    this.beforeUpdate = function (id, name, manager) {
        $http.get('/managers/getAll').then(function (response) {
            var managers = response.data;
            var selector = document.getElementById("managerUPD");
            $(selector).empty();
            for (var i = 0; i < routes.length; i++) {
                var option = document.createElement("option");
                if (managers[i].id == manager.id){
                    option.selected = 'selected';
                }
                option.text = managers[i].name;
                option.value = managers[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
    };

    this.updateSection = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var index = document.getElementById("managerUPD").selectedIndex;
        var managerId = document.getElementById("managerUPD").options[index].value;
        $http.get('/managers/getById?id='+managerId).then(function (response) {
            var selectedManager = response.data;
            var req = {
                method: 'POST',
                url: '/sections/update?id=' + id,
                data: {
                    name: name,
                    manager: selectedManager
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        })
    };

    this.deleteSection = function (id) {
        $http.delete('sections/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

