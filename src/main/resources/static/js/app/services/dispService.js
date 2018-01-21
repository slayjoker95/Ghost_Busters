servicesModule.service('DispService', function($http, SERVER_URL, $rootScope) {

    this.getOrders = function () {
        return $http.get(SERVER_URL + 'api/order')
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                return [];
            });
    }

    this.getOrderStatuses = function() {
        return $http.get(SERVER_URL+'api/o_status')
            .then(function(response){
                return response.data;
            }).catch(function(err) {
                return [];
            });
    }

    this.updateOrder = function(newSelectedOrder, orderStatuses){
        for (var i in orderStatuses){
            var orderStatus = orderStatuses[i]
            if (orderStatus.id == 2)
                newSelectedOrder.orderStatus = orderStatus;
        }
        $http.put(SERVER_URL + 'api/order/'+ newSelectedOrder.id, JSON.stringify(newSelectedOrder));
    }

    this.updateDoneOrder = function(doneSelectedOrder, orderStatuses){
        for (var i in orderStatuses){
            var orderStatus = orderStatuses[i]
            if (orderStatus.id == 5)
                doneSelectedOrder.orderStatus = orderStatus;
        }
        $http.put(SERVER_URL + 'api/order/'+ doneSelectedOrder.id, JSON.stringify(doneSelectedOrder));
    }
});