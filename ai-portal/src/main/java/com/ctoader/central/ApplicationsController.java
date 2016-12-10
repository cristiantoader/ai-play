package com.ctoader.central;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by crist on 11/27/2016.
 */
@RestController
public class ApplicationsController {

    @Autowired
    private ApplicationsService applicationsService;

    @RequestMapping("/applications")
    List<Application> getAvailableApplications() {
        return this.applicationsService.getAvailableApplications();
    }
}
