var app = angular.module("my_req_8", []);

app.controller("req_8", function ($http, $scope){

    $http.get('/sections/getAll').then(function (response){
        var groups = response.data;
        var selector = document.getElementById("Sections");
        $(selector).empty();
        for (var i = 0; i < groups.length; i++) {
            var option = document.createElement("option");
            option.text = groups[i].name;
            option.value = groups[i].id;
            selector.add(option);
        }
    });


    this.request = function add() {

        var indexOfGroup = document.getElementById("Sections").selectedIndex;
        section_id = document.getElementById("Sections").options[indexOfGroup].value;

        $scope.tourists = [];
        $http.get('/groups/getCountGroupsBySection?id=' + section_id).then(function (response){

            document.getElementById("Rez").innerText = response.data;

        });

    };

});