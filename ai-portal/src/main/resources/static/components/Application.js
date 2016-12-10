
var module = angular.module('AiPortal')

module.factory('Application', function($http, EndpointConstants) {

    var Application = function() {
        this.name = null;
        this.pictureUrl = null;
        this.applicationUrl = null;
    };

    Application.fetchAll = function(successCallback, errorCallback) {
        $http
            .get(EndpointConstants.APPLICATIONS_LIST)

            .success(function(response) {
                var applications = [];

                // process list of applications received from server.
                response.forEach(function(responseItem) {
                    var application = new Application();
                    application.name = responseItem.name;
                    application.pictureUrl = responseItem.pictureUrl;
                    application.applicationUrl = responseItem.applicationUrl;
                    applications.push(application);
                });

                // and return them to caller.
                successCallback(applications);
            })

            .error(function(response) {
                if (errorCallback != null) {
                    errorCallback(response);
                }
            });
    };

    return Application;
});