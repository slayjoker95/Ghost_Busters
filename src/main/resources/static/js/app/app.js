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
        }).when('/new', {
            templateUrl:'views/new.html',
            controller:'UserController'
        }).when('/userOrders', {
            templateUrl:'views/userOrders.html',
            controller:'UserController'
        }).when('/orderView', {
            templateUrl:'views/orderView.html',
            controller:'UserController'
        }).when('/newOrders', {
            templateUrl:'views/newOrders.html',
            controller:'DispController'
        }).when('/newOrderView', {
            templateUrl:'views/newOrderView.html',
            controller:'DispController'
        }).when('/huntOrders', {
            templateUrl:'views/huntOrders.html',
            controller:'HunterController'
        }).when('/equipOrders', {
            templateUrl:'views/equipOrders.html',
            controller:'EquipController'
        }).when('/equipOrderView', {
            templateUrl:'views/equipOrderView.html',
            controller:'EquipController'
        }).when('/doneOrders', {
            templateUrl:'views/doneOrders.html',
            controller:'DispController'
        }).when('/doneOrderView', {
            templateUrl:'views/doneOrdersView.html',
            controller:'DispController'
        });

    })

    .constant('SERVER_URL', 'http://localhost:8080/');