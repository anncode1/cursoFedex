package com.anncode.contactosappintents.model;

import java.io.Serializable;

/**
 * Created by anahisalgado on 07/07/16.
 */
public class Contact implements Serializable {
    private String picture;
    private String name;
    private String phone;
    private String website;

    public Contact(String picture, String name, String phone, String website) {
        this.picture = picture;
        this.name = name;
        this.phone = phone;
        this.website = website;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
