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
  })
    .when('/foods/add', {
      templateUrl: path + 'add.html',
      controller: 'addController'
  });
});

app.controller('foodsController', function($scope, $http){
  $scope.message = "Lista wszystich dostępnych produktów. Jeżeli nie ma tego, czego szukasz <<dodaj>> produkt do bazy.";
  $http({
    url: url + 'foods/show',
    dataType: 'json',

  }).then(function(success){
     $scope.foods = success.data
    },  function(error){
      console.error(error);
    });
});

app.controller('addController', function($scope, $http){
    $http({
        url: url + 'foodType/show',
        dataType: 'json'
    }).then(function(success){
        $scope.foodTypes;
    });
})


