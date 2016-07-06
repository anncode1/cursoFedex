package com.anncode.fragments.model;

/**
 * Created by anahisalgado on 06/07/16.
 */
public class Task {

    private String name;
    private String urlImage;

    public Task(String name, String urlImage) {
        this.name = name;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
