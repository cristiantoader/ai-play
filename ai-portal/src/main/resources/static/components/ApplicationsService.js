
var module = angular.module('AiPortal')

module.factory('ApplicationsService', function($log, Application) {
    var service = {};

    service.applications = [];
    Application.fetchAll(function(applications) {
        service.applications.length = 0;
        applications.forEach(function(application) {
            service.applications.push(application)
        })
    });

    return service;
});