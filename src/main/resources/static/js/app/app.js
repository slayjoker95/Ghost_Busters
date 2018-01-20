const myApp = angular.module('ghostBustersApp', ["ngRoute", "ghostBustersAppControllers", "ghostBustersAppServices"])
    .config(function($routeProvider) {
        $routeProvider.when('/hunterLogin', {
            templateUrl:'views/hunterLogin.html',
            controller:'HunterLoginController'
        }).when('/logout', {
            templateUrl:'views/logout.html',
            controller:'LogoutController'
        }).when('/loginUser', {
            templateUrl:'views/loginUser.html',
            controller:'UserLoginController'
        });

    })

    .constant('SERVER_URL', 'http://localhost:8080/');