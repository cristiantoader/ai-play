
var module = angular.module('AiWeb');

module.factory('AiMessage', function() {
    var AiMessage = function() {
        this.message = null;
        this.author = null;
        this.mood = null;
    }

    AiMessage.fromMsg = function(msg) {
        var aiMessage = new AiMessage();
        aiMessage.message = msg;
        aiMessage.author = 'Web';
        aiMessage.mood = 'NORMAL';
        return aiMessage;
    }

    return AiMessage;
});