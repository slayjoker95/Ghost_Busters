var controllerModule = angular.module('ghostBustersAppControllers', ['ui.grid','ui.grid.pagination']);
controllerModule.controller('MainController', function($scope, $rootScope, $location, MainService, UserLoginService) {
    $rootScope.menu = MainService.getMenu();

    $rootScope.$on('reload_page_event', function(event, data) {
        $rootScope.menu = MainService.getMenu();
        $location.path('/');
    });

});