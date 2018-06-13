var app = angular.module("my_req_10", []);

app.controller("req_10", function ($http, $scope){

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

        $scope.tourists = [];
        $http.get('/groups/getCountGroupsByCoach?id=' + section_id).then(function (response){

            document.getElementById("Rez").innerText = response.data;

        });

    };

});