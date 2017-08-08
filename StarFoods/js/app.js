
var app = angular.module('RESTApp', ['ngRoute', 'ui.bootstrap']);
var url = 'http://localhost:8080/';

app.config(function($routeProvider){
  var path = './views/';
  $routeProvider
  .when('/', {
    templateUrl: path + 'main.html',
    controller: 'searchController'
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
  })
    .when('/rate/:id',{
      templateUrl: path + 'product.html',
      controller: 'productController'
  })
    .when('/scores',{
      templateUrl: path + 'best.html',
      controller: 'ratingController'
  })
});



app.service('addMsgService', function(){
    this.message = undefined;
    this.addMsg = function(message){
        this.message = message;
    }
    this.getMsg = function(){
        var message = this.message;
        this.message = undefined;
        return message;
    }
  
});

app.controller('showController', function($scope, $http, $timeout, addMsgService){
 
  $http({
    url: url + 'products/show',
      dataType: 'json'
  }).then(function(success){
      $scope.products = success.data
      $scope.message = addMsgService.getMsg();
      $timeout(function(){
          $scope.message = undefined;
      }, 2000);
     
    },  function(error){
      console.error(error);
    });
});

app.controller('addController', function($scope, $http, $window, addMsgService){
   
    $http({
    url: url + 'products/show',
        dataType: 'json'
  }).then(function(success){
     $scope.products = success.data
    },  function(error){
      console.error(error);
    });
    
    $scope.submitForm =function(){
        
        if($scope.addForm.$valid){
           $scope.add();            
        }
    }
    
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

          $scope.message =  addMsgService.addMsg("Produkt dodano pomyślnie!") 
         $window.location.href = "/#!show";
            
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
        var ratings = 0;
        for(var rate of $scope.product.ratings) {
            ratings += rate.rating_value;
        }
        ratings /= $scope.product.ratings.length;
        $scope.product.score = ratings;
    }, function(error){
        console.error(error);
    });
    
    $scope.stars = function(){
        
        var value = $('.stars > input:checked').val();
        $http({
            url: url + 'products/rate/' +id,
            dataType: 'json',
            params: {
                value: value
            }
        }).then(function (success){
            $scope.message = "Twoja ocena została zapisana. Dziękujemy!"
           
        })   
    }
    
});


app.controller('ratingController', function($scope, $http){
    $http({ 
        url: url + 'products/scores',
        dataType: 'json'
    }).then( function(success){
        $scope.products = success.data
    }, function(error){
        console.error(error);
    });
    
});

app.controller('searchController', function($scope, $http){
    
     $http({ 
        url: url + 'products/show',
        dataType: 'json'
    }).then( function(success){
        $scope.products = success.data
    }, function(error){
        console.error(error);
    });
    
    $scope.search = function(){
       $http({
            url: url + 'products/search',
            method: 'GET',
            dataType: 'json',
            params: {
                userInput: $scope.asyncSelected
            }
        }).then(function(success){
            $scope.products = success.data
        }, function(error) {
            console.error(error)
        });   
    }
    
    $scope.getLocation = function(val) {
        return $http.get(url + 'products/search', {
          params: {
            userInput: val,
          }
        }).then(function(response){
          return response.data.map(function(item){
            return item.name;
          });
        });
      };

});







