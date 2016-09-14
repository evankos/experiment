angular.module('experiment.app', ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/overview', {
                templateUrl: '/my-app/app-section/overview.htm'
            })
            .otherwise({redirectTo: '/index'});
    });