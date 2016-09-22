
var app = angular.module('experiment.app', [
    //'ngRoute',
    //'ui.router',
    'ngAnimate',
    'angularAudioRecorder'
]);
app.config(function ($locationProvider) {

    //$locationProvider.html5Mode({
    //    enabled: true,
    //    requireBase: true
    //});

    //$stateProvider
    //
    //    .state('experiment', {
    //        url: '/experiment',
    //        templateUrl: 'experiment/pages/proceding'
    //    });
    //$routeProvider
    //    //.when('/login', {
    //    //    templateUrl: 'pages/login',
    //    //    //controller: 'loginController'
    //    //})
    //    .when('/experiment', {
    //        templateUrl: 'pages/proceding',
    //        //controller: 'experimentController'
    //    })
    //    .otherwise({
    //        redirectTo: '/login'
    //    });

    //angular.extend($modalProvider.defaults, {
    //    html: true,
    //    animation: 'am-fade-and-slide-top'
    //});
});
