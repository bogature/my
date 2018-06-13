var app = angular.module("my_req_2", []);

app.controller("req_2", function ($http, $scope){

    $http.get('/groups/getAll').then(function (response){
        var groups = response.data;
        var selector = document.getElementById("Groups");
        $(selector).empty();
        for (var i = 0; i < groups.length; i++) {
            var option = document.createElement("option");
            option.text = groups[i].name;
            option.value = groups[i].id;
            selector.add(option);
        }
    });


    this.request = function add() {

        var indexOfGroup = document.getElementById("Groups").selectedIndex;
        group_id = document.getElementById("Groups").options[indexOfGroup].value;

        $scope.tourists = [];
        $http.get('/tourists/getCountTouristByGroup?group_id=' + group_id).then(function (response){

            document.getElementById("Rez").innerText = response.data;

        });

    };

});