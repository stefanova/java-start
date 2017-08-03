//var app2 = angular.module('RESTApp', ['ngRoute']);
//
//var url = 'http://localhost:8080/';
//
//app2.config(function($routeProvider){
//  var path = './views/';
//  $routeProvider
//  .when('/', {
//    templateUrl: path + 'main.html',
//    controller: 'searchController'
//  });
//});
//
//
//
//app.controller('searchController', function($scope, $http){
//    $http({
//        url: url + 'products/search',
//        dataType: 'json',
//        params:{ 
//        userInput: $scope.userInput
//        }     
//    }).then(function(success){
//        $scope.products = success.data
//    }, function(error){
//        console.error(error)
//    });
//    
//});