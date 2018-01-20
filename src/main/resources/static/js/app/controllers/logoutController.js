controllerModule.controller('LogoutController', function($scope, $rootScope) {

    $scope.$on('$routeChangeSuccess', function () {
        $rootScope.hunter = undefined;
        $rootScope.user = undefined;
        $rootScope.disp = undefined;
        $rootScope.equip = undefined;
        $rootScope.$broadcast('reload_page_event');
    });

});