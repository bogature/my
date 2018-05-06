var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.routes = [];
    $http.get('/routes/getAll').then(function (response) {
        $scope.routes = response.data;
        //   console.log(response);
    });


    this.insertRoute = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var distance = document.getElementById("distance").value;
        var req = {
            method: 'POST',
            url: '/routes/insert',
            data: {
                name: name,
                distance: distance
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };


    this.beforeUpdate = function (id, name, distance) {
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        document.getElementById("distanceUPD").value = distance;
    };

    this.updateRoute = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var distance = document.getElementById("distanceUPD").value;
        var req = {
            method: 'POST',
            url: '/routes/update?id=' + id,
            data: {
                name: name,
                distance: distance
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };

    this.deleteRoute = function (id) {
        $http.delete('routes/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

