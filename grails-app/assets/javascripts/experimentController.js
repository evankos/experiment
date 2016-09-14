(function () {
    'use strict';

    angular.module('experiment.app').controller('experimentController', function ($scope, $location, $http) {

        $scope.resetReport = function () {
            $scope.report = {
                "id": null,
                "name": "",
                "url": "",
                "description": "",
                "isActive": true,
                "isExternalAllowed": false,
                "managementOnly": false,
                "parentReportName": null,
                "category": {id:1},
                "subscriptions": []
            }
            $scope.subReports = [];
        };
        'use strict';
        console.log("hello");
        $http({
            method: 'GET',
            url: '/api/sentences'
        }).then(function successCallback(response) {
            console.log(response.data[1]);
        }, function errorCallback(response) {
            console.log(response);
        });
        $scope.listen = function () {
            if(!$scope.listening){

                $scope.listening = true;
                $scope.listener.listen("en", function(text) {
                    document.getElementById("text").value = text;
                });
            }
            else
            {
                $scope.listener.stop()
                $scope.listening = false;
            }

        };
        $scope.listener = new webspeech.Listener();
        $scope.listening = false;


    })
})();

