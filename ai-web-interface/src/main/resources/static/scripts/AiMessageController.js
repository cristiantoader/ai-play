
var module = angular.module('AiWeb');

module.controller('AiMessageController', function($scope, $interval, AiMessageService) {
    $scope.inputMessage = '';
    $scope.messages = [];

    $scope.sendMessage = function() {
        AiMessageService.sendMessage($scope.inputMessage, function(response) {
            // add own message to the list
            $scope.messages.push($scope.inputMessage);
            $scope.inputMessage = '';
        });
    };

    /* Periodically poll for messages. */
    var listenForMessages = function() {
        AiMessageService.listen(function(response) {
            if (response != null && response.length != 0) {
                $scope.messages.push(response);
            }
        });
    }
    $interval(listenForMessages, 2000);

});