package com.anncode.fragments.model;

/**
 * Created by anahisalgado on 06/07/16.
 */
public class TaskDesciption {

    private String name;
    private String description;

    public TaskDesciption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
