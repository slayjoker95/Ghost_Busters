controllerModule.controller('UserLoginController', function($scope, $rootScope, $location, UserLoginService) {

    $scope.loginUser = function() {
        UserLoginService.loginUser($scope.user, function(response) {
            if (response.success) {
                $rootScope.$broadcast('reload_page_event');
            }
        });
    }

    $scope.$on('registration_event', function(event, data) {
        console.log('YYYYYY');
    });

});