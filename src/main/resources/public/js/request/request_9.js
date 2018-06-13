var app = angular.module("my_req_9", []);

app.controller("req_9", function ($http, $scope){

    $http.get('/coaches/getAll').then(function (response){
        var groups = response.data;
        var selector = document.getElementById("Coaches");
        $(selector).empty();
        for (var i = 0; i < groups.length; i++) {
            var option = document.createElement("option");
            option.text = groups[i].name;
            option.value = groups[i].id;
            selector.add(option);
        }
    });


    this.request = function add() {

        var indexOfGroup = document.getElementById("Coaches").selectedIndex;
        section_id = document.getElementById("Coaches").options[indexOfGroup].value;

        $scope.coaches = [];
        $http.get('/groups/getGroupsByCoach?id=' + section_id).then(function (response){

            document.getElementById("Rez").innerText = " ";
            $scope.coaches = response.data;

            console.log($scope.coaches);

            if ($scope.coaches.length <= 0) {
                document.getElementById("Rez").innerText = "Даної інформації в базі не знайдено";
            }


        });

    };

});