(function () {
    'use strict';

    angular.module('experiment.app').controller('loginController', function ($scope, $location, $http) {

        'use strict';
        console.log("LOGIN CONTROLLER");
        $scope.error={
            message:""
        }
        $scope.subject = {
            id:"",
            name:""
        };

        $scope.register= function(){
            var res = $http.post('/api/login', $scope.subject);
            res.success(function(data, status, headers, config) {
                $scope.error.message = "";
                //$location.path('/experiment/pages/proceding');
                //$location.path("/experiment");
                //$state.go('experiment');
                window.location.href = '/experiment/pages/proceding';
            });
            res.error(function(data, status, headers, config) {
                $scope.error.message = JSON.stringify({data: data})
            });
        };

    })
})();

