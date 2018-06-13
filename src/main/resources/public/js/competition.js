var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.competitions = [];
    $http.get('/competitions/getAll').then(function (response) {
        $scope.competitions = response.data;
        console.log(response);
    });

    this.beforeInsert = function () {
        $http.get('/sections/getAll').then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("section");
            $(selector).empty();
            for (var i = 0; i < sections.length; i++) {
                var option = document.createElement("option");
                option.text = sections[i].name;
                option.value = sections[i].id;
                selector.add(option);
            }
        });
    };

    this.insertCompetition = function () {
        // var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var date = document.getElementById("date").value;
        var sections = [];
        var items = [];
        $('#section option:selected').each(function(){ items.push($(this).val()); });
        console.log(items);

        for (var i = 0; i < items.length; i++){
            $http.get('/sections/getById?id='+items[i]).then(function (response) {
                var selectedSection = response.data;
                console.log(selectedSection);
                //tourists.add(selectedTourist);
                sections.push(selectedSection);
            });
        }
        console.log(sections);
                    var req = {
                        method: 'POST',
                        url: '/competitions/insert',
                        data: {
                            name: name,
                            date: date,
                            sections: sections
                        }
                    };
                    console.log(req);
                    $http(req).then(function (resp) {
                      //  window.location.reload();
                    })
    };

    this.beforeUpdate = function (id,name,date,selectedSections) {
        $http.get('/sections/getAll').then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("sectionUPD");
            $(selector).empty();
            for (var i = 0; i < sections.length; i++) {
                var option = document.createElement("option");
                for (var j = 0; j < selectedSections.length; j++){
                    if (sections[i].id == selectedSections[j].id){
                        option.selected = 'selected';
                    }
                }
                option.text = sections[i].name;
                option.value = sections[i].id;
                selector.add(option);
            }
        });
        document.getElementById("idUPD").innerText = id;
        document.getElementById("nameUPD").value = name;
        document.getElementById("dateUPD").value = date;
    };

    this.updateCompetition = function () {
        var id = document.getElementById("idUPD").innerText;
        var name = document.getElementById("nameUPD").value;
        var date = document.getElementById("dateUPD").value;
        var sections = [];
        var items = [];
        $('#section option:selected').each(function(){ items.push($(this).val()); });
        console.log(items);

        for (var i = 0; i < items.length; i++){
            $http.get('/sections/getById?id='+items[i]).then(function (response) {
                var selectedSection = response.data;
                console.log(selectedSection);
                //tourists.add(selectedTourist);
                sections.push(selectedSection);
            });
        }
                    var req = {
                        method: 'POST',
                        url: '/competitions/update?id=' + id,
                        data: {
                            name: name,
                            date: date,
                            sections: sections
                        }
                    };
                    console.log(req);
                    $http(req).then(function (resp) {
                        window.location.reload();
                    })
    };


    this.deleteCompetition = function (id) {
        $http.delete('competitions/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});


