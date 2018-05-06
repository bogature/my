var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.schedules = [];
    $http.get('/schedules/getAll').then(function (response) {
        $scope.schedules = response.data;

    });



    this.beforeInsert = function () {
        $http.get("/sections/getAll").then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("section")
            $(selector).empty();
            for (var i = 0; i < sections.length; i++) {
                var option = document.createElement("option");
                option.text = sections[i].name;
                option.value = sections[i].value;
                selector.add(option);
            }
        })
    };

    this.getId = function () {
        $http.get('/sections/getById?id='+31).then(function (response) {
            var list =response.data;
            document.getElementById("lol").value = list;
        })
    }
    this.insertSchedule = function () {
        // var id = document.getElementById("id").value;
        var count = document.getElementById("count").value;
        var place = document.getElementById("place").value;
        var time = document.getElementById("time").value;
        var index = document.getElementById("section").selectedIndex;
        var sectionId = document.getElementById("section").options[index].value;
        $http.get('/sections/getById?id='+sectionId).then(function (response) {
            var selectedSection = response.data;
            var req = {
                method: 'POST',
                url: '/schedules/insert',
                data: {
                   section: selectedSection,
                    count: count,
                    place: place,
                    time: time
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
    };


    this.beforeUpdate = function (id, section, count, place, time) {
        $http.get('/sections/getAll').then(function (response) {
            var sections = response.data;
            var selector = document.getElementById("sectionUPD");
            $(selector).empty();
            for (var i = 0; i < sections.length; i++) {
                var option = document.createElement("option");
                if (sections[i].id == section.id){
                    option.selected = 'selected';
                }
                option.text = sections[i].name;
                option.value = sections[i].id;
                selector.add(option);
            }
        });
        document.getElementById("countUPD").innerText = count;
        document.getElementById("placeUPD").value = place;
        document.getElementById("timeUPD").value = time;
    };

    this.updateSchedule = function () {
        var id = document.getElementById("idUPD").innerText;
        var count = document.getElementById("countUPD").value;
        var place = document.getElementById("placeUPD").value;
        var time = document.getElementById("timeUPD").value;
        var index = document.getElementById("sectionUPD").selectedIndex;
        var sectionId = document.getElementById("sectionUPD").options[index].value;
        $http.get('/sections/getById?id='+sectionId).then(function (response) {
            var selectedSection = response.data;
            var req = {
                method: 'POST',
                url: '/schedules/update?id=' + id,
                data: {
                    section: selectedSection,
                    count: count,
                    place: place,
                    time: time
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        })
    };

    this.deleteSchedule = function (id) {
        $http.delete('schedules/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});

// $(document).ready(function () {
//     $('#example').DataTable({
//         "order": [[3, "desc"]]
//     });
// });
// $('.selectpicker').selectpicker(
//     {
//         liveSearchPlaceholder: 'Placeholder text',
//         style: 'btn-info',
//         size: 4
//     }
// );
$(document).ready(function() {
    $('.selections').select2();
});