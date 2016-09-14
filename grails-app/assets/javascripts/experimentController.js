(function () {
    'use strict';

    angular.module('experiment.app').controller('experimentController', function ($scope, timeService, $location, $http) {

        $scope.solution={
            userId:"",
            userName:"",
            sentenceId:"",
            solution:"",
            sentence:"",
            order:"",
            time:0
        };
        $scope.error={
            message:""
        }
        $scope.subject = {
            id:"",
            name:""
        };
        $scope.iteration = {};
        $scope.sentence = "";
        $scope.registering=true;
        $scope.orderIndex = 0;
        $scope.sequenceIndex = 0;
        $scope.sequenceIndex_ = 0;
        $scope.overallCounter = 1;
        $scope.done= false;

        $scope.register= function(){
            timeService.eventTrigger();
            $scope.registering = !$scope.registering
            console.log($scope.subject)
        };
        'use strict';
        console.log("hello");
        $http({
            method: 'GET',
            url: '/api/sentences'
        }).then(function successCallback(response) {
            $scope.error.message = ""
            $scope.iteration = response.data;
            $scope.overallCounter = $scope.iteration.sequence.length
        }, function errorCallback(response) {
            $scope.error.message = JSON.stringify({data: response.data})
        });


        $scope.listen = function () {
            if(!$scope.listening){

                $scope.listening = true;
                $scope.listener.listen("en", function(text) {
                    //$scope.sentence = text;
                    document.getElementById("text").value = text;
                });
            }
            else
            {
                $scope.listener.stop()
                $scope.listening = false;
            }

        };
        $scope.send = function(){
            timeService.eventTrigger();
            $scope.sequenceIndex_ = $scope.sequenceIndex % $scope.overallCounter
            if($scope.listening){
                $scope.listener.stop()
                $scope.listening = false;
            }
            $scope.solution={
                userId:$scope.subject.id,
                userName:$scope.subject.name,
                sentenceId:$scope.iteration.sequence[$scope.sequenceIndex_],
                solution:document.getElementById("text").value,
                sentence:$scope.iteration.sentences[$scope.iteration.sequence[$scope.sequenceIndex_]],
                order:$scope.iteration.orders[$scope.orderIndex],
                time:timeService.getInterval()
            };
            var res = $http.post('/api/sentences', $scope.solution);
            res.success(function(data, status, headers, config) {
                $scope.error.message = ""
            });
            res.error(function(data, status, headers, config) {
                $scope.error.message = JSON.stringify({data: data})
            });

            $scope.sequenceIndex ++;
            $scope.orderIndex =  Math.floor($scope.sequenceIndex / $scope.overallCounter);
            if(typeof $scope.iteration.orders[$scope.orderIndex] === 'undefined'){
                $scope.done = true;
            }
            document.getElementById("text").value = "";
        };
        $scope.listener = new webspeech.Listener();
        $scope.listening = false;


    })
})();

