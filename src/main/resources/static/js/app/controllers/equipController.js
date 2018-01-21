controllerModule.controller('EquipController', function($scope, $http, $location, $rootScope, EquipService) {
    $scope.orders = [];
    $scope.equipStatuses= [];
    $scope.myOrders = [];

    EquipService.getOrders().then(function(orders){
        $scope.orders = orders;
        for (var i in $scope.orders)
        {
            var order = $scope.orders[i];
            if (order.orderStatus.name != "Выполнен и подтверждён" && order.orderStatus.name != "Не подтверждён" && order.equipStatus.name != "Возвращена" && order.equipStatus.name != "Не возвращена")
                $scope.myOrders[$scope.myOrders.length] = order;
        }
    });

    $scope.setEquipSelectedOrder = function (order) {
        $rootScope.equipSelectedOrder = order;
        console.log("function called!!!");
        $location.path('/equipOrderView');
    }

    EquipService.getEquipStatuses().then(function(equipStatuses){
        $scope.equipStatuses = equipStatuses;
    });

    $scope.submit = function() {
        EquipService.updateOrder($rootScope.equipSelectedOrder, function(response){
            $scope.zzz = response;
        });
        $location.path('/equipOrders');
    }
});