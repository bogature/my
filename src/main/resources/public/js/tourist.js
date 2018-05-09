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

    this.beforeUpdate = function (id,name,age,gender,dateOfBirth,groups,difficultyLevel,typeOfTourist) {
        $http.get('/groups/getAll').then(function (response) {
            var groups1 = response.data;
            var selector = document.getElementById("groupsUPD");
            $(selector).empty();
            for (var i = 0; i < groups1.length; i++) {
                var option = document.createElement("option");
                if (groups1[i].id == groups.id){
                    option.selected = 'selected';
                }
                option.text = groups1[i].name;
                option.value = groups1[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        document.getElementById("ageUPD").value = age;
        document.getElementById("genderUPD").value = gender;
        document.getElementById("difficultyLevelUPD").value = difficultyLevel;
        document.getElementById("typeOfTouristUPD").value = typeOfTourist;
    };

    this.updateTourist = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var age = document.getElementById("ageUPD").value;
        var indexGender = document.getElementById("genderUPD").selectedIndex;
        var gender = document.getElementById("genderUPD").options[indexGender].innerHTML;
        var dateOfBirth = document.getElementById("dateOfBirthUPD").value;
        var indexGroup = document.getElementById("groupsUPD").selectedIndex;
        var groupId = document.getElementById("groupsUPD").options[indexGroup].value;
        var indexDifficultyLevel = document.getElementById("difficultyLevelUPD").selectedIndex;
        var difficultyLevel = document.getElementById("difficultyLevelUPD").options[indexDifficultyLevel].innerHTML;
        var indexTypeOfTourist = document.getElementById("typeOfTouristUPD").selectedIndex;
        var typeOfTourist = document.getElementById("typeOfTouristUPD").options[indexTypeOfTourist].innerHTML;
        $http.get('/groups/getById?id='+groupId).then(function (response) {
            var selectedGroup = response.data;
            var req = {
                method: 'POST',
                url: '/tourists/update?id=' + id,
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
        })
    };

    this.deleteTourist = function (id) {
        $http.delete('tourist/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

