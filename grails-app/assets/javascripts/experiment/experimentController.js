(function () {
    'use strict';

    angular.module('experiment.app').controller('experimentController', function ($scope, timeService, $location, $http, $timeout) {
        'use strict';
        $scope.solution={
            solution:"",
            sentence:"",
            order:"",
            time:0
        };
        $scope.error={
            message:""
        };
        $scope.ibmSolution={
            id:"dsfsdf",
            name:"sdfsdf",
            payload:null
        };

        $scope.audioModel = null;
        $scope.cordovaMedia = {
            recorder: null,
            url: null,
            player: null
        };
        $scope.status={
            isRecording:false,
            isDenied:false
        };


        $scope.serverInteraction = false;
        $scope.create_email = false;
        $scope.final_transcript = '';
        $scope.recognizing = false;
        $scope.ignore_onend = false;
        $scope.start_timestamp = null;
        $scope.dynamic = 0;
        $scope.max = 30;


        $http({
            method: 'GET',
            url: '/api/sentences'
        }).then(function successCallback(response) {
            console.log(response.data);
            $scope.solution.sentence=response.data.sentence;
            $scope.solution.order=response.data.order;
            $scope.dynamic = response.data.index;
            timeService.eventTrigger();
        }, function errorCallback(response) {
            $scope.error.message = JSON.stringify({data: response.data})
        });

        $scope.logout = function(){

            var res = $http({
                method: 'GET',
                url: '/api/out'
            });
            res.success(function(response){
                window.location.href = '/';
            });
            res.error(function(response){
                $scope.error.message = JSON.stringify({data: response.data});
            });
        };
        $scope.send_secure = function(){
            if(!$scope.serverInteraction) $scope.send();
        };

        $scope.send = function(){
            timeService.eventTrigger();


            if($scope.listening){
                $scope.listener.stop()
                $scope.listening = false;
            }
            $scope.solution.solution= document.getElementById("text").value;
            $scope.solution.time= timeService.getInterval();
            $scope.serverInteraction = true;
            var res = $http.post('/api/sentences', $scope.solution);
            res.success(function(data, status, headers, config) {

                if(data.order=="DONE"){
                    $scope.serverInteraction = false;
                    if ($scope.recognizing) {
                        $scope.recognition.stop();
                        $scope.recognizing = false;
                        return;
                    }
                    timeService.eventTrigger();
                    window.location.href = '/';
                }
                else{
                    $scope.serverInteraction = true;
                    $scope.error.message = "";
                    if(data.index == '0'){
                        $scope.solution.order= "MODULE STARTING";
                        $scope.solution.sentence="IN 4...";
                        $timeout(function() {$scope.solution.sentence="IN 3...";}, 1000)
                            .then(function(){$timeout(function() {$scope.solution.sentence="IN 2...";}, 1000)
                                .then(function(){$timeout(function() {$scope.solution.sentence="IN 1...";}, 1000)
                                    .then(function(){$timeout(function() {$scope.solution.sentence="NOW!!!";}, 1000)
                                        .then(function(){
                                            $scope.solution.sentence=data.sentence;
                                            $scope.solution.order=data.order;
                                            $scope.dynamic = data.index;
                                            $scope.serverInteraction = false;
                                            timeService.eventTrigger();
                                        })})})});
                    }else{
                        $scope.serverInteraction = false;
                        $scope.solution.sentence=data.sentence;
                        $scope.solution.order=data.order;
                        $scope.dynamic = data.index;
                        timeService.eventTrigger();
                    }
                }
            });
            res.error(function(data, status, headers, config) {
                $scope.serverInteraction = false;
                $scope.error.message = JSON.stringify({data: data});
            });
            $scope.final_transcript = '';
            document.getElementById("text").value = "";
        };
        $scope.showInfo = function(s){
            $scope.error.message = s;
        };

    })
})();

