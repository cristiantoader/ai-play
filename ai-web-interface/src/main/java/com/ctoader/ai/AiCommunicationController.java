package com.ctoader.ai;

import com.ctoader.ai.model.AiMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by crist on 11/12/2016.
 */
@RestController
public class AiCommunicationController {

    private AiCommunicationService aiCommunicationService;

    @Autowired
    public AiCommunicationController(AiCommunicationService aiCommunicationService) {
        this.aiCommunicationService = aiCommunicationService;
    }

    @RequestMapping(value = "/tell", method = RequestMethod.POST)
    public void tell(@RequestBody AiMessage message) {
        this.aiCommunicationService.tell(message);
    }

    @RequestMapping(value = "/listen", method = RequestMethod.GET)
    public AiMessage listen() {
        return this.aiCommunicationService.listen();
    }

}
