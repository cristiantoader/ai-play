package com.ctoader.ai.model;

/**
 * Created by crist on 11/12/2016.
 */
public class AiMessage {
    private String message;
    private String author;
    private AiMessageMood mood;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public AiMessageMood getMood() {
        return mood;
    }

    public void setMood(AiMessageMood mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "AiMessage{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", mood=" + mood +
                '}';
    }
}
