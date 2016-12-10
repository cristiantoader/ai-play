package com.ctoader.file.app.pool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by crist on 11/27/2016.
 */
@Configuration
public class ExecutorServiceBeanFactory {

    @Value("${ai.file-manager.maximum-thread-count}")
    private int maximumThreadCount;

    @Bean
    public ExecutorService makeExecutorServiceBean() {
        return Executors.newFixedThreadPool(maximumThreadCount);
    }
}
