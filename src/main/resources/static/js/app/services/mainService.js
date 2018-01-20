var servicesModule = angular.module('ghostBustersAppServices', ['ui.grid','ui.grid.pagination']);
servicesModule.service('MainService', function($http, $rootScope, SERVER_URL) {
    this.getMenu = function() {
        var menu = [];

        if ($rootScope.hunter !== undefined) {
            menu.push({title: 'Выйти', url: '#/logout', f: 'logout()'});
            menu.push({title: 'Мои заявки', url: '#/huntOrders', f: ''});
        } else {
            if ($rootScope.user !== undefined) {
                menu.push({title: 'Подать заявку', url: '#/new', f: ''});
                menu.push({title: 'Мои заявки', url: '#/userOrders', f: ''});
                menu.push({title: 'Выйти', url: '#/logout', f: 'logout()'});
            }
            else {
                if ($rootScope.disp !== undefined) {
                    menu.push({title: 'Новые заявки', url: '#/newOrders', f: ''});
                    menu.push({title: 'Выполненные заявки', url: '#/doneOrders', f: ''});
                    menu.push({title: 'Выйти', url: '#/logout', f: 'logout()'});
                }
                else {
                    if ($rootScope.equip !== undefined) {
                        menu.push({title: 'Мои заявки', url: '#/equipOrders', f: ''});
                        menu.push({title: 'Выйти', url: '#/logout', f: 'logout()'});
                    }
                    else {
                        menu.push({title: 'Войти', url: '#/loginUser', f: ''});
                        menu.push({title: 'Войти как охотник', url: '#/hunterLogin', f: ''});
                    }
                }
            }
        }
        return menu;
    }
});