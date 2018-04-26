var app = angular.module("my", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.tourists = [];
    $http.get('/tourists/getAll').then(function (response) {
        $scope.tourists = response.data;
        //   console.log(response);
    });
    $scope.tours = [];
    $http.get('/api/getAllTours').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.tours = response.data;
        //  console.log(response);
    });
    $scope.coaches = [];
    $http.get('/api/getAllCoaches').then(function (response) {
        $scope.coaches = response.data;
        //   console.log(response);
    });
    $scope.sections = [];
    $http.get('/api/getAllSections').then(function (response) {
        $scope.sections = response.data;
        //   console.log(response);
    });
    $scope.groups = [];
    $http.get('/api/getAllGroups').then(function (response) {
        $scope.groups = response.data;
        //   console.log(response);
    });
    $scope.checkpoints = [];
    $http.get('/api/getAllCheckpoints').then(function (response) {
        $scope.checkpoints = response.data;
        //   console.log(response);
    });
    $scope.managers = [];
    $http.get('/api/getAllManagers').then(function (response) {
        $scope.managers = response.data;
        //   console.log(response);
    });
    $scope.instructors = [];
    $http.get('/api/getAllInstructors').then(function (response) {
        $scope.instructors = response.data;
        //   console.log(response);
    });
    $scope.routes = [];
    $http.get('/api/getAllRoutes').then(function (response) {
        $scope.routes = response.data;
        //   console.log(response);
    });
    // this.delstud = function del(id) {
    //     $http.get('/api/student/del?id='+id).then(function (response){
    //         //  $http.get('http://localhost:8080/api/students').then(function (response){
    //         // $scope.students=response.data;
    //         window.alert('Student ' + response.data.lastName + ' ' + response.data.firstName + ' has been succesfully deleted!');
    //         window.location.reload();9
    //     });
    // }
    //
    // $scope.groups = [];
    // $http.get('/api/groups').then(function (response){
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.groups=response.data;
    //     console.log(response);
    // });
    //
    //*
    // this.delchair = function del(id) {
    //     $http.get('/api/chair/del?id=' + id).then(function (response) {
    //         window.alert('Chair ' + ' ' + response.data.name + ' ' + response.data.id + ' ' + response.data.abr + ' ' + ' has been succesfully deleted!');
    //         window.location.reload();
    //     });
    // };
    //
    //
    this.inserttourist = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var age = document.getElementById("age").value;
        var gender = document.getElementById("gender").value;
        var dateOfBirth = document.getElementById("dateOfBirth").value;
        var group = document.getElementById("group").value;
        var typeOfTourist = document.getElementById("typeOfTourist").value;
        var difficultyLevel = document.getElementById("difficultyLevel").value;
        var req = {
            method: 'POST',
            url: '/tourists/insert',
            data: {
                id: id,
                name: name,
                age: age,
                gender: gender,
                dateOfBirth: dateOfBirth,
                group: group.name,
                typeOfTourist: typeOfTourist,
                difficultyLevel: difficultyLevel
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };
    // $scope.showInsert = true;
    // $scope.showUpdate = false;
    // $scope.disabledId = false;
    // var chair;
    // this.hideInsertButton = function (item) {
    //     document.getElementById("id").value = item.id;
    //     document.getElementById("name").value = item.name;
    //     document.getElementById("abr").value = item.abr;
    //     $scope.disabledId = true;
    //     chair = item;
    //     $scope.showInsert = false;
    //     $scope.showUpdate = true;
    // };
    //
    // this.cancelUpdate = function () {
    //     $scope.showInsert = true;
    //     $scope.showUpdate = false;
    //     window.location.reload();
    // };
    //
    // this.updatechair = function () {
    //     var id = document.getElementById("id").value;
    //     var name = document.getElementById("name").value;
    //     var abr = document.getElementById("abr").value;
    //     var req = {
    //         method: 'POST',
    //         url: '/api/chair/update',
    //         data: {
    //             id: id,
    //             name: name,
    //             abr: abr
    //         }
    //     };
    //     // console.log(req);
    //     $http(req).then(function (resp) {
    //
    //         window.location.reload();
    //     });
    //
    // };
    // $scope.showInsert = true;
    // $scope.showUpdate = false;
    // $scope.disabledId = false;


});

