package com.ctoader.ai;

import com.ctoader.ai.model.AiMessage;

/**
 * Created by crist on 11/12/2016.
 */
public interface AiCommunicationService {
    void tell(AiMessage inputMessage);
    AiMessage listen();
}
