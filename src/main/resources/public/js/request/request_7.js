var app = angular.module("my_req_7", []);

app.controller("req_7", function ($http, $scope){

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

        $scope.groups = [];
        $http.get('/groups/getGroupsBySection?id=' + section_id).then(function (response){

            document.getElementById("Rez").innerText = " ";
            $scope.groups = response.data;

            console.log($scope.tourists.length);

            if ($scope.tourists.length <= 0) {
                document.getElementById("Rez").innerText = "Даної інформації в базі не знайдено";
            }


        });

    };

});