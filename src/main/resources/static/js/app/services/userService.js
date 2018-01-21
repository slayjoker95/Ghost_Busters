servicesModule.service('UserService', function($http, SERVER_URL, $rootScope) {

    this.getOrders = function() {
        return $http.get(SERVER_URL+'api/order')
            .then(function(response){
                return response.data;
            }).catch(function(err) {
                return [];
            });
    }

    this.getHunters = function() {
        return $http.get(SERVER_URL+'api/hunter')
            .then(function(response){
                return response.data;
            }).catch(function(err) {
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

    this.getEquipStatuses = function() {
        return $http.get(SERVER_URL+'api/equip_status')
            .then(function(response){
                return response.data;
            }).catch(function(err) {
                return [];
            });
    }

    this.addNewOrder = function(newOrder, hunters, orderStatuses, equipStatuses) {
        console.log("posting data....");
        for (var i in hunters) {
            var hunter = hunters[i];
            if (hunter.level == newOrder.ghost_lvl && hunter.busy == false)
                newOrder.hunter = hunter;
        }
        for (var j in orderStatuses){
            var orderStatus = orderStatuses[j];
            if (orderStatus.id == 1)
                newOrder.orderStatus = orderStatus;
        }
        for (var k in equipStatuses){
            var equipStatus = equipStatuses[k];
            if (equipStatus.id == 1)
                newOrder.equipStatus = equipStatus;
        }
        newOrder.user = $rootScope.user;
        return $http.post(SERVER_URL+'api/order', JSON.stringify(newOrder)).success(function(){
            console.log("success");
        });
    }
});