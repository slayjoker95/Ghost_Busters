controllerModule.controller('UserController', function($scope, $http, $location, $rootScope, UserService) {
    $scope.orders = [];
    $scope.hunters = [];
    $scope.orderStatuses = [];
    $scope.equipStatuses = [];
    $scope.ownOrders = [];

    UserService.getOrders().then(function(orders){
        $scope.orders = orders;
        for (var i in $scope.orders)
        {
            var order = $scope.orders[i];
            if (order.user.user_id == $rootScope.user.user_id)
                $scope.ownOrders[$scope.ownOrders.length] = order;
        }
    });

    UserService.getHunters().then(function(hunters){
        $scope.hunters = hunters;
    });

    UserService.getOrderStatuses().then(function(orderStatuses){
        $scope.orderStatuses = orderStatuses;
    });

    UserService.getEquipStatuses().then(function(equipStatuses){
        $scope.equipStatuses = equipStatuses;
    });

    $scope.newOrder = {};
    $scope.submit = function() {
        UserService.addNewOrder($scope.newOrder, $scope.hunters, $scope.orderStatuses, $scope.equipStatuses).then(function () {
            UserService.getOrders().then(function(orders){
                $scope.orders = orders;
            });
            console.log("completed");
            $location.path('/userOrders');
        });
    }

    $scope.setSelectedOrder = function (order) {
        $rootScope.selectedOrder = order;
        console.log("function called!!!");
        $location.path('/newOrderView');
    }

});