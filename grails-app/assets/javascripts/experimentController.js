(function () {
    'use strict';

    angular.module('experiment.app').controller('experimentController', function ($scope, timeService, $location, $http) {
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





        $http({
            method: 'GET',
            url: '/api/sentences'
        }).then(function successCallback(response) {
            console.log(response.data);
            $scope.solution.sentence=response.data.sentence;
            $scope.solution.order=response.data.order;
            timeService.eventTrigger();
        }, function errorCallback(response) {
            $scope.error.message = JSON.stringify({data: response.data})
        });



        $scope.send = function(){
            timeService.eventTrigger();
            if ($scope.recognizing) {
                $scope.recognition.stop();
            }
            if($scope.listening){
                $scope.listener.stop()
                $scope.listening = false;
            }
            $scope.solution.solution= document.getElementById("text").value;
            $scope.solution.time= timeService.getInterval();

            var res = $http.post('/api/sentences', $scope.solution);
            res.success(function(data, status, headers, config) {

                if(data.order=="DONE"){
                    window.location.href = '/';
                    timeService.eventTrigger();
                }
                else{
                    $scope.error.message = "";
                    $scope.solution.sentence=data.sentence;
                    $scope.solution.order=data.order;
                    timeService.eventTrigger();
                }

            });
            res.error(function(data, status, headers, config) {
                $scope.error.message = JSON.stringify({data: data});
            });
            $scope.final_transcript = '';
            document.getElementById("text").value = "";
        };
        $scope.showInfo = function(s){
            $scope.error.message = s;
        };
        
        $scope.create_email = false;
        $scope.final_transcript = '';
        $scope.recognizing = false;
        $scope.ignore_onend = false;
        $scope.start_timestamp = null;
        if (!('webkitSpeechRecognition' in window)) {
            //upgrade();
            console.log("No webkit");
            $scope.error.message = "Please update your chrome version to >33";
        } else {

            $scope.recognition = new webkitSpeechRecognition();
            $scope.recognition.continuous = true;
            $scope.recognition.interimResults = true;
            $scope.recognition.onstart = function () {
                $scope.recognizing = true;
                //showInfo('info_speak_now');
                //start_img.src = 'mic-animate.gif';
            };
            $scope.recognition.onerror = function (event) {
                if (event.error == 'no-speech') {
                    //start_img.src = 'mic.gif';
                    $scope.showInfo('info_no_speech');
                    $scope.ignore_onend = true;
                }
                if (event.error == 'audio-capture') {
                    //start_img.src = 'mic.gif';
                    $scope.showInfo('info_no_microphone');
                    $scope.ignore_onend = true;
                }
                if (event.error == 'not-allowed') {
                    if (event.timeStamp - $scope.start_timestamp < 100) {
                        $scope.showInfo('info_blocked');
                    } else {
                        $scope.showInfo('info_denied');
                    }
                    $scope.ignore_onend = true;
                }
            };
            //$scope.recognition.onend = function () {
            //    $scope.recognizing = false;
            //    if ($scope.ignore_onend) {
            //        return;
            //    }
            //    //start_img.src = 'mic.gif';
            //    if (!$scope.final_transcript) {
            //        $scope.showInfo('info_start');
            //        return;
            //    }
            //    $scope.showInfo('');
            //    if (window.getSelection) {
            //        window.getSelection().removeAllRanges();
            //        var range = document.createRange();
            //        range.selectNode(document.getElementById('final_span'));
            //        window.getSelection().addRange(range);
            //    }
            //    if (create_email) {
            //        create_email = false;
            //        createEmail();
            //    }
            //};
            $scope.recognition.onresult = function (event) {
                var interim_transcript = '';
                for (var i = event.resultIndex; i < event.results.length; ++i) {
                    if (event.results[i].isFinal) {
                        $scope.final_transcript += event.results[i][0].transcript;
                    } else {
                        interim_transcript += event.results[i][0].transcript;
                    }
                }

                document.getElementById("text").value = $scope.final_transcript;
            };
        }
        $scope.startButton = function (event) {
            if ($scope.recognizing) {
                $scope.recognition.stop();
                $scope.recognizing = false;
                return;
            }
            $scope.recognizing = true;
            $scope.final_transcript = '';
            document.getElementById("text").value = $scope.final_transcript;
            $scope.recognition.lang = 'en-US';
            $scope.recognition.start();
            $scope.ignore_onend = false;
            $scope.showInfo('info_allow');
            $scope.start_timestamp = event.timeStamp;
        }

    })
})();

