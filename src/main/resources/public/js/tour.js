var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.tours = [];
    $http.get('/tours/getAll').then(function (response) {
        $scope.tours = response.data;
           console.log(response);
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
        $http.get('/instructors/getAll').then(function (response) {
            var instructors = response.data;
            var selector = document.getElementById("instructor");
            $(selector).empty();
            for (var i = 0; i < instructors.length; i++) {
                var option = document.createElement("option");
                option.text = instructors[i].name;
                option.value = instructors[i].id;
                selector.add(option);
            }
        });
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
        $http.get('/tourists/getAll').then(function (response) {
            var tourists = response.data;
            var selector = document.getElementById("tourist");
            $(selector).empty();
            for (var i = 0; i < tourists.length; i++) {
                var option = document.createElement("option");
                option.text = tourists[i].name;
                option.value = tourists[i].id;
                selector.add(option);
            }
        });
    };

    this.insertTour = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var indexGroup = document.getElementById("groups").selectedIndex;
        var groupId = document.getElementById("groups").options[indexGroup].value;
        var indexInstructor = document.getElementById("instructor").selectedIndex;
        var instructorId = document.getElementById("instructor").options[indexInstructor].value;
        var indexDifficultyLevel = document.getElementById("difficultyLevel").selectedIndex;
        var difficultyLevel = document.getElementById("difficultyLevel").options[indexDifficultyLevel].innerHTML;
        var countOfBerths = document.getElementById("countOfBerths").value;
        var time = document.getElementById("time").value;
        var indexTypeOfTour = document.getElementById("typeOfTour").selectedIndex;
        var typeOfTour = document.getElementById("typeOfTour").options[indexTypeOfTour].innerHTML;
        var indexRoute = document.getElementById("route").selectedIndex;
        var routeId = document.getElementById("route").options[indexRoute].value;
        var tourists = [];
        var items = [];
        $('#tourist option:selected').each(function(){ items.push($(this).val()); });
        console.log(items);

        for (var i = 0; i < items.length; i++){
            $http.get('/tourists/getById?id='+items[i]).then(function (response) {
                var selectedTourist = response.data;
                console.log(selectedTourist);
                //tourists.add(selectedTourist);
                tourists.push(selectedTourist);
            });
        }
        $http.get('/groups/getById?id='+groupId).then(function (response) {
            var selectedGroup = response.data;
            $http.get('/instructors/getById?id='+instructorId).then(function (response) {
                var selectedInstructor = response.data;
                $http.get('/routes/getById?id='+routeId).then(function (response) {
                    var selectedRoute = response.data;
            var req = {
                method: 'POST',
                url: '/tours/insert',
                data: {
                    name: name,
                    groups: selectedGroup,
                    instructor: selectedInstructor,
                    difficultyLevel: difficultyLevel,
                    countOfBerths: countOfBerths,
                    time: time,
                    typeOfTour: typeOfTour,
                    route: selectedRoute,
                    tourists: tourists
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
        });
        });
    };

    this.beforeUpdate = function (id,name,selectedGroups,instructor,difficultyLevel,countOfBerths,time,typeOfTour,route,selectedTourists) {
        $http.get('/groups/getAll').then(function (response) {
            var groups = response.data;
            var selector = document.getElementById("groupsUPD");
            $(selector).empty();
            for (var i = 0; i < groups.length; i++) {
                var option = document.createElement("option");
                if (groups[i].id == selectedGroups.id){
                    option.selected = 'selected';
                }
                option.text = groups[i].name;
                option.value = groups[i].id;
                selector.add(option);
            }
        });
        $http.get('/instructors/getAll').then(function (response) {
            var instructors = response.data;
            var selector = document.getElementById("instructorUPD");
            $(selector).empty();
            for (var i = 0; i < instructors.length; i++) {
                var option = document.createElement("option");
                if (instructors[i].id == instructor.id){
                    option.selected = 'selected';
                }
                option.text = instructors[i].name;
                option.value = instructors[i].id;
                selector.add(option);
            }
        });
        $http.get('/routes/getAll').then(function (response) {
            var routes = response.data;
            var selector = document.getElementById("routeUPD");
            $(selector).empty();
            for (var i = 0; i < routes.length; i++) {
                var option = document.createElement("option");
                if (routes[i].id == route.id){
                    option.selected = 'selected';
                }
                option.text = routes[i].name;
                option.value = routes[i].id;
                selector.add(option);
            }
        });
        $http.get('/tourists/getAll').then(function (response) {
            var tourists = response.data;
            var selector = document.getElementById("touristUPD");
            $(selector).empty();
            for (var i = 0; i < tourists.length; i++) {
                var option = document.createElement("option");
                for (var j = 0; j < selectedTourists.length; j++){
                    if (tourists[i].id == selectedTourists[j].id){
                        option.selected = 'selected';
                    }
                }
                option.text = tourists[i].name;
                option.value = tourists[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        document.getElementById("difficultyLevelUPD").value = difficultyLevel;
        document.getElementById("countOfBerthsUPD").value = countOfBerths;
        document.getElementById("timeUPD").value = time;
        document.getElementById("typeOfTourUPD").value = typeOfTour;
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

    this.deleteTour = function (id) {
        $http.delete('tours/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});


