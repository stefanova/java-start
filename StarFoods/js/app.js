var app = angular.module('RESTApp', ['ngRoute']);
var url = 'http://localhost:8080/';

app.config(function($routeProvider){
  var path = './views/';
  $routeProvider
  .when('/', {
    templateUrl: path + 'main.html'
  })
  .when('/foods',{
    templateUrl: path + 'foods.html',
    controller: 'foodsController'
  });
});

app.controller('foodsController', function($scope, $http){
  $scope.message = "Lista wszystich dostępnych produktów. Jeżeli nie ma tego, czego szukasz <<dodaj>> produkt do bazy.";
  $http({
    url: url + 'foods',
    dataType: 'json',
    params: {}
  }).then(function(success){
    $scope.name = success.data.name;
},  function(error){
  console.error(error);
});
});
