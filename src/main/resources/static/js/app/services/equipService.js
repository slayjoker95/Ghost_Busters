servicesModule.service('EquipService', function($http, SERVER_URL, $rootScope) {

    this.getOrders = function () {
        return $http.get(SERVER_URL + 'api/order')
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                return [];
            });
    }

    this.getEquipStatuses = function () {
        return $http.get(SERVER_URL + 'api/equip_status')
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                return [];
            });
    }

    this.updateOrder = function(equipSelectedOrder){
        $http.put(SERVER_URL + 'api/order/'+ equipSelectedOrder.id, JSON.stringify(equipSelectedOrder));
    }
});