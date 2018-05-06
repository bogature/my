var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.groups = [];
    $http.get('/groups/getAll').then(function (response) {
        $scope.groups = response.data;
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
        $http.get('/coaches/getAll').then(function (response) {
            var coaches = response.data;
            var selector = document.getElementById("coach");
            $(selector).empty();
            for (var i = 0; i < coaches.length; i++) {
                var option = document.createElement("option");
                option.text = coaches[i].name;
                option.value = coaches[i].id;
                selector.add(option);
            }
        });
    };

    this.insertGroup = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var indexSection = document.getElementById("section").selectedIndex;
        var indexCoach = document.getElementById("coach").selectedIndex;
        var sectionId = document.getElementById("section").options[indexSection].value;
        var coachId = document.getElementById("coach").options[indexCoach].value;
        $http.get('/sections/getById?id=' + sectionId).then(function (response) {
            var selectedSection = response.data;
            $http.get('/coaches/getById?id=' + coachId).then(function (response) {
                var selectedCoach = response.data;
            var req = {
                method: 'POST',
                url: '/groups/insert',
                data: {
                    name: name,
                    section: selectedSection,
                    coach: selectedCoach
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
        });
    };

    this.beforeUpdate = function (id, name, section, coach) {
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
        $http.get('/coaches/getAll').then(function (response) {
            var coaches = response.data;
            var selector = document.getElementById("coachUPD");
            $(selector).empty();
            for (var i = 0; i < coaches.length; i++) {
                var option = document.createElement("option");
                if (coaches[i].id == coach.id) {
                    option.selected = 'selected';
                }
                option.text = coaches[i].name;
                option.value = coaches[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
    };

    this.updateGroup = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var indexSection = document.getElementById("sectionUPD").selectedIndex;
        var indexCoach = document.getElementById("coachUPD").selectedIndex;
        var sectionId = document.getElementById("sectionUPD").options[indexSection].value;
        var coachId = document.getElementById("coachUPD").options[indexCoach].value;
        $http.get('/sections/getById?id=' + sectionId).then(function (response) {
            var selectedSection = response.data;
            $http.get('/coaches/getById?id=' + coachId).then(function (response) {
                var selectedCoach = response.data;
                var req = {
                    method: 'POST',
                    url: '/groups/update?id=' + id,
                    data: {
                        name: name,
                        section: selectedSection,
                        coach: selectedCoach
                    }
                };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
        });
    };

    this.deleteGroup = function (id) {
        $http.delete('groups/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

