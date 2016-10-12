(function () {
    'use strict';

    angular.module('experiment.app').service('timeService', function () {
        var counterStarted= false;
        var start= null;
        var end= null;

        var eventTrigger = function () {
            if(!counterStarted){
                start = new Date();
                counterStarted = true;
            }
            else
            {
                end = new Date();
                counterStarted = false;
            }
        };

        var getInterval = function () {
            if(start!=null && end != null){
                return Math.abs(end - start);
            }
        };
        return {
            eventTrigger: eventTrigger,
            getInterval : getInterval
        };
    });
})();