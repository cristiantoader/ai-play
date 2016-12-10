
var module = angular.module('AiWeb');

module.factory('AiMessageService', function($http, $log, AiMessage) {
    var service = {};

    service.sendMessage = function(msg, successCallback) {
        var aiMessage = AiMessage.fromMsg(msg);

        $http.post('/ai/tell', aiMessage).success(successCallback)
            .error(function(response) {
                $log.warn('Received error from service.')
            });
    }

    service.listen = function(successCallback) {
        $http.get('/ai/listen')
            .success(function(response) {
                successCallback(response.message);
            })
            .error(function(response) {
                $log.warn('Error received from service.');
            });
    }

    return service;
});