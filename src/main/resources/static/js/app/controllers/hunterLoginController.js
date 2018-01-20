controllerModule.controller('HunterLoginController', function($scope, $rootScope, $location, HunterLoginService) {

    $scope.loginHunter = function() {
        HunterLoginService.loginHunter($scope.hunter, function(response) {
            if (response.success) {
                console.log('Successfully logged in under ' + $rootScope.hunter.name);
                $rootScope.$broadcast('reload_page_event');
            } else {
                console.log('Login under ' + $scope.hunter.name + ' failed');
            }
        });
    }

    $scope.$on('registration_event', function(event, data) {
        console.log('YYYYYY');
    });

});