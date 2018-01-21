servicesModule.service('HunterService', function($http, SERVER_URL, $rootScope) {

    this.getOrders = function () {
        return $http.get(SERVER_URL + 'api/order')
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                return [];
            });
    }

    this.getOrderStatuses = function () {
        return $http.get(SERVER_URL + 'api/o_status')
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                return [];
            });
    }

    this.updateOrder = function(myOrder){
        $http.put(SERVER_URL + 'api/order/'+ myOrder.id, JSON.stringify(myOrder));
    }
});