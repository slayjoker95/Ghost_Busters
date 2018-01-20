servicesModule.service('HunterLoginService', function($http, $rootScope, SERVER_URL) {
    var allHunters = [];

    this.loginHunter = function (user, callback) {
        console.log('Login user, name=' + user.name + ', password=' + user.password);
        var resp = {success: false, message: 'Username or password is incorrect'};

        $http.get(SERVER_URL + 'api/hunter').then(function (response) {
            allHunters = response.data;
            console.log('Found ' + allHunters.length + ' users');

            for (var i in allHunters) {
                var usr = allHunters[i];
                console.log('Name: ' + usr.name + ', password: ' + usr.password);

                if (usr.name === user.name && usr.password === user.password) {
                    console.log("User matches!!!");
                    $rootScope.hunter = user;
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