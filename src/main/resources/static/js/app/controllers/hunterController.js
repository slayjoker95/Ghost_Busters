controllerModule.controller('HunterController', function($scope, $http, $location, $rootScope, HunterService) {
    $scope.myOrder = {};
    $scope.orders = [];
    $scope.orderStatuses= [];

    HunterService.getOrders().then(function(orders){
        $scope.orders = orders;
        for (var i in $scope.orders)
        {
            var order = $scope.orders[i];
            if (order.orderStatus.name != "Выполнен и подтверждён" && order.orderStatus.name != "Не подтверждён" && order.hunter.id == $rootScope.hunter.id)
                $scope.myOrder = order;
        }
    });

    HunterService.getOrderStatuses().then(function(orderStatuses){
        for (var i in orderStatuses){
            var orderStatus = orderStatuses[i];
            if (orderStatus.name != "Выполнен и подтверждён")
                $scope.orderStatuses[$scope.orderStatuses.length] = orderStatus
        }
    });

    $scope.submit = function() {
        HunterService.updateOrder($scope.myOrder, function(response){
            $scope.zzz = response;
        });
    }

    $scope.setSelectedOrder = function (order) {
        $rootScope.selectedOrder = order;
        console.log("function called!!!");
        $location.path('/newOrderView');
    }
});