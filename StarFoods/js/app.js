var app = angular.module('RESTApp', ['ngRoute']);
var url = 'http://localhost:8080/';

app.config(function($routeProvider){
  var path = './views/';
  $routeProvider
  .when('/', {
    templateUrl: path + 'main.html'
  })
  .when('/show',{
    templateUrl: path + 'products.html',
    controller: 'showController'
  })
    .when('/add', {
      templateUrl: path + 'add.html',
      controller: 'addController'
  })
    .when('/show/:id',{
      templateUrl: path + 'product.html',
      controller: 'productController'
  });
});

app.controller('showController', function($scope, $http){
 
  $http({
    url: url + 'products/show',
      dataType: 'json'
  }).then(function(success){
     $scope.products = success.data
    },  function(error){
      console.error(error);
    });
});

app.controller('addController', function($scope, $http){
   
    $http({
    url: url + 'products/show',
        dataType: 'json'
  }).then(function(success){
     $scope.products = success.data
    },  function(error){
      console.error(error);
    });

    $scope.add = function(){ 
    
        $http({
        url: url + 'products/add',
        method: 'GET',
        dataType: 'json',
        params: {
            name: $scope.name,
            brand: $scope.brand,
            comment: $scope.comment,
            image: $scope.image
        }
    }).then(function(success){
        console.log(success);
        $scope.message = "Poprawnie dodano produkt"
    }, function(error) {
        console.error(error)
    });
        
    }
});

app.controller('productController', function($scope, $http, $routeParams){
   var id = $routeParams.id;
    $http({
        url: url + 'products/show/' + id,
        dataType: 'json'
        }).then( function (success){
        $scope.product = success.data;
    }, function(error){
        console.error(error);
    });
    
});


