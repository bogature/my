var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.instructors = [];
    $http.get('/instructors/getAll').then(function (response) {
        $scope.instructors = response.data;
        //   console.log(response);
    });

    this.beforeInsert = function () {
        $http.get('/managers/getAll').then(function (response) {
            var managers = response.data;
            var selector = document.getElementById("manager");
            $(selector).empty();
            for (var i = 0;i < managers.length; i++) {
                var option = document.createElement("option");
                option.text = managers[i].name;
                option.value = managers[i].id;
                selector.add(option);
            }
        });
    };

    this.insertSection = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var index = document.getElementById("manager").selectedIndex;
        var managerId = document.getElementById("manager").options[index].value;
        $http.get('/managers/getById?id='+managerId).then(function (response) {
            var selectedManager = response.data;
            var req = {
                method: 'POST',
                url: '/instructors/insert',
                data: {
                    name: name,
                    manager: selectedManager
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
            for (var i = 0;i < managers.length; i++) {
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
                url: '/managers/update?id=' + id,
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

