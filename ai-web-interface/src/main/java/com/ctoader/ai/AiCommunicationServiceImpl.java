package com.ctoader.ai;

import com.ctoader.ai.model.AiMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by crist on 11/12/2016.
 */
@Service
public class AiCommunicationServiceImpl implements AiCommunicationService {

    private volatile Queue<AiMessage> thoughtsQueue = new LinkedBlockingQueue<>();

    private static final Logger LOG = LoggerFactory.getLogger(AiCommunicationServiceImpl.class);

    public void tell(AiMessage inputMessage) {
        LOG.info("Was told {}.", inputMessage);
        thoughtsQueue.offer(inputMessage);
    }

    public AiMessage listen() {
        if (thoughtsQueue.isEmpty()) {
            return null;
        }

        LOG.info("Going to say {}.", thoughtsQueue.peek());
        return thoughtsQueue.poll();
    }
}
