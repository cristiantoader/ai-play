package com.ctoader.central;

/**
 * Created by crist on 11/27/2016.
 */
public class Application {

    private String name;
    private String pictureUrl;
    private String applicationUrl;

    public Application() {
    }

    public Application(String name, String pictureUrl, String applicationUrl) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.applicationUrl = applicationUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }
}
