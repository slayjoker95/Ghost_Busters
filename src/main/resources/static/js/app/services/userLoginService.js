servicesModule.service('UserLoginService', function($http, $rootScope, SERVER_URL) {
    var allUsers = [];

    this.loginUser = function (user, callback) {
        console.log('Login user, name=' + user.name + ', password=' + user.password);
        var resp = {success: false, message: 'Username or password is incorrect'};

        $http.get(SERVER_URL + 'api/user').then(function (response) {
            allUsers = response.data;
            console.log('Found ' + allUsers.length + ' users');

            for (var i in allUsers) {
                var usr = allUsers[i];
                console.log('Name: ' + usr.name + ', password: ' + usr.password);

                if (usr.name === user.name && usr.password === user.password) {
                    console.log("User matches!!!");
                    if (usr.role == 'Диспетчер')
                        $rootScope.disp = user;
                    else
                    {
                        if (usr.role == 'Пользователь')
                            $rootScope.user = user;
                        else {
                            if (usr.role == 'Поставщик')
                                $rootScope.equip = user;
                                }
                    }
                    resp = {success: true};
                }
            }

            callback(resp);
        }).catch(function (err) {
            console.log('Error occurred: ' + err.statusText);
            callback(resp);
        });

    }
});