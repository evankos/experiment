/**
 * Created by Vaggelis on 10/12/2016.
 */
(function () {
    'use strict';
    angular.module('administration.app').controller('administrationController', function($scope, $http, $filter, ngTableParams) {
        $scope.search = function (firstResult, itemsPerPage) {
            var param = {
                "firstResult": firstResult,
                "itemsPerPage": itemsPerPage
            };
            return $http.post('/api/results', JSON.stringify(param));
        };
        console.log('exeq');
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10,          // count per page
            sorting: {
                name: 'asc'     // initial sorting
            }
        }, {
            total: 0,           // length of data
            getData: function($defer, params) {
                $scope.search((params.page() - 1) * params.count(), params.count())
                    .success(function (result) {
                        $scope.items = result.items;
                        params.total(result.totalCount);
                        $defer.resolve(result.items);
                    });
            }
        });


    });
})();