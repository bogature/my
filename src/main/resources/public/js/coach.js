var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.coaches = [];
    $http.get('/coaches/getAll').then(function (response) {
        $scope.coaches = response.data;
        //   console.log(response);
    });

    this.beforeInsert = function () {
        $http.get('/sections/getAll').then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("section");
            $(selector).empty();
            for (var i = 0; i < sections.length; i++) {
                var option = document.createElement("option");
                option.text = sections[i].name;
                option.value = sections[i].id;
                selector.add(option);
            }
        });
    };

    this.insertCoach = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var salary = document.getElementById("salary").value;
        var index = document.getElementById("section").selectedIndex;
        var sectionId = document.getElementById("section").options[index].value;
        $http.get('/sections/getById?id=' + sectionId).then(function (response) {
            var selectedSection = response.data;
            var req = {
                method: 'POST',
                url: '/coaches/insert',
                data: {
                    name: name,
                    age: age,
                    salary: salary,
                    section: selectedSection
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
    };

    this.beforeUpdate = function (id, name, age, salary, section) {
        $http.get('/sections/getAll').then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("sectionUPD");
            $(selector).empty();
            for (var i = 0; i < sections.length; i++) {
                var option = document.createElement("option");
                if (sections[i].id == section.id) {
                    option.selected = 'selected';
                }
                option.text = sections[i].name;
                option.value = sections[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        document.getElementById("ageUPD").value = age;
        document.getElementById("salaryUPD").value = salary;
    };

    this.updateCoach = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var age = document.getElementById("ageUPD").value;
        var salary = document.getElementById("salaryUPD").value;
        var index = document.getElementById("sectionUPD").selectedIndex;
        var sectionId = document.getElementById("sectionUPD").options[index].value;
        $http.get('/sections/getById?id=' + sectionId).then(function (response) {
            var selectedSection = response.data;
            var req = {
                method: 'POST',
                url: '/coaches/update?id=' + id,
                data: {
                    name: name,
                    age: age,
                    salary: salary,
                    section: selectedSection
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        })
    };

    this.deleteCoach = function (id) {
        $http.delete('coaches/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

