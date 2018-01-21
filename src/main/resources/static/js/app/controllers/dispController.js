controllerModule.controller('DispController', function($scope, $http, $location, $rootScope, DispService) {
    $scope.orders = [];
    $scope.newOrders = [];
    $scope.orderStatuses = []
    $scope.doneOrders = [];

    DispService.getOrders().then(function(orders){
        $scope.orders = orders;
        for (var i in $scope.orders)
        {
            var order = $scope.orders[i];
            if (order.orderStatus.name == "Не подтверждён")
                $scope.newOrders[$scope.newOrders.length] = order;
            if (order.orderStatus.name == "Выполнен")
                $scope.doneOrders[$scope.doneOrders.length] = order;
        }
    });

    DispService.getOrderStatuses().then(function(orderStatuses){
        $scope.orderStatuses = orderStatuses;
    });

    $scope.setNewSelectedOrder = function (order) {
        $rootScope.newSelectedOrder = order;
        console.log("function called!!!");
        $location.path('/newOrderView');
    }

    $scope.setDoneSelectedOrder = function (order) {
        $rootScope.doneSelectedOrder = order;
        console.log("function called!!!");
        $location.path('/doneOrderView');
    }

    $scope.updateNewOrder = function () {
        DispService.updateOrder($rootScope.newSelectedOrder, $scope.orderStatuses, function(response){
            $scope.zzz = response;
        });
        $location.path('/newOrders');
    }

    $scope.updateDoneOrder = function () {
        DispService.updateDoneOrder($rootScope.doneSelectedOrder, $scope.orderStatuses, function(response){
            $scope.zzz = response;
        });
        $location.path('/doneOrders');
    }
});