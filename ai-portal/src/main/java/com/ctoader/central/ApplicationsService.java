package com.ctoader.central;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 11/27/2016.
 */
@Service
public class ApplicationsService {

    private static final List<Application> APPLICATIONS_LIST = Arrays.asList(
        new Application("ai-web-interface", "assets/img/ai.jpg", "http://localhost:8081/ai/index.html"),
        new Application("ai-file-manager", "assets/img/file.png", "http://localhost:8082/files/index.html")
    );

    List<Application> getAvailableApplications() {
        return APPLICATIONS_LIST;
    }
}
