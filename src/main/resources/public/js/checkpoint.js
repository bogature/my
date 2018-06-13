var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.checkpoints = [];
    $http.get('/checkpoints/getAll').then(function (response) {
        $scope.checkpoints = response.data;
        //   console.log(response);
    });

    this.beforeInsert = function () {
        $http.get('/routes/getAll').then(function (response) {
            var routes = response.data;
            var selector = document.getElementById("route");
            $(selector).empty();
            for (var i = 0; i < routes.length; i++) {
                var option = document.createElement("option");
                option.text = routes[i].name;
                option.value = routes[i].id;
                selector.add(option);
            }
        });
    };

    this.insertCheckpoint = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var index = document.getElementById("route").selectedIndex;
        var routeId = document.getElementById("route").options[index].value;
        $http.get('/routes/getById?id=' + routeId).then(function (response) {
            var selectedRoute = response.data;
            var req = {
                method: 'POST',
                url: '/checkpoints/insert',
                data: {
                    name: name,
                    route: selectedRoute
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
    };

    this.beforeUpdate = function (id, name,route) {
        $http.get('/routes/getAll').then(function (response) {
            var routes = response.data;
            var selector = document.getElementById("routeUPD");
            $(selector).empty();
            for (var i = 0; i < routes.length; i++) {
                var option = document.createElement("option");
                if (routes[i].id == route.id) {
                    option.selected = 'selected';
                }
                option.text = routes[i].name;
                option.value = routes[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
    };

    this.updateCheckpoint = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var index = document.getElementById("routeUPD").selectedIndex;
        var routeId = document.getElementById("routeUPD").options[index].value;
        $http.get('/routes/getById?id=' + routeId).then(function (response) {
            var selectedRoute = response.data;
            var req = {
                method: 'POST',
                url: '/checkpoints/update?id=' + id,
                data: {
                    name: name,
                    route: selectedRoute

                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        })
    };

    this.deleteCheckpoint = function (id) {
        $http.delete('checkpoints/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

$(document).ready(function () {
    $('#example').DataTable({
        "order": [[3, "desc"]]
    });
});

