var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.instructors = [];
    $http.get('/instructors/getAll').then(function (response) {
        $scope.instructors = response.data;
        //   console.log(response);
    });


    this.insertInstructor = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var indexDifficultyLevel = document.getElementById("difficultyLevel").selectedIndex;
        var difficultyLevel = document.getElementById("difficultyLevel").options[indexDifficultyLevel].innerHTML;
        var indexTypeOfInstructor = document.getElementById("typeOfInstructor").selectedIndex;
        var typeOfInstructor = document.getElementById("typeOfInstructor").options[indexTypeOfInstructor].innerHTML;
            var req = {
                method: 'POST',
                url: '/instructors/insert',
                data: {
                    name: name,
                    difficultyLevel: difficultyLevel,
                    typeOfInstructor: typeOfInstructor
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })

    };

    this.beforeUpdate = function (id, name, difficultyLevel,typeOfInstructor) {
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        var difficultyLevelSelected = document.getElementById("difficultyLevel");
        difficultyLevelSelected.value = difficultyLevel;
        var typeOfInstructorSelected = document.getElementById("typeOfInstructor");
        typeOfInstructorSelected.value = typeOfInstructor;
    };

    this.updateInstructor = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var indexDifficultyLevel = document.getElementById("difficultyLevelUPD").selectedIndex;
        var difficultyLevel = document.getElementById("difficultyLevelUPD").options[indexDifficultyLevel].innerHTML;
        var indexTypeOfInstructor = document.getElementById("typeOfInstructorUPD").selectedIndex;
        var typeOfInstructor = document.getElementById("typeOfInstructorUPD").options[indexTypeOfInstructor].innerHTML;
            var req = {
                method: 'POST',
                url: '/instructors/update?id=' + id,
                data: {
                    name: name,
                    difficultyLevel: difficultyLevel,
                    typeOfInstructor: typeOfInstructor
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
    };

    this.deleteInstructor = function (id) {
        $http.delete('instructors/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

