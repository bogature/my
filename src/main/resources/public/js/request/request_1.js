var app = angular.module("my_req_1", []);

app.controller("req_1", function ($http, $scope){

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
        $http.get('/tourists/getTouristByGroup?group_id=' + group_id).then(function (response){

            document.getElementById("Rez").innerText = " ";
            $scope.tourists = response.data;

            console.log($scope.tourists.length);

            if ($scope.tourists.length <= 0) {
                document.getElementById("Rez").innerText = "Даної інформації в базі не знайдено";
            }


        });

    };

});