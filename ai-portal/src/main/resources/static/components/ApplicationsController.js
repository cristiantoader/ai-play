
var module = angular.module('AiPortal')

module.controller('ApplicationsController', function($scope, ApplicationsService) {
    $scope.applications = ApplicationsService.applications;
});