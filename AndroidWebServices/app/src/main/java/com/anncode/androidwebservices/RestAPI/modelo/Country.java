package com.anncode.androidwebservices.RestAPI.modelo;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class Country {

    private String  code;
    private String  name;
    private int     area;
    private String  region;
    private int[]   latlng;

    public Country(String code, String name, int area, String region, int[] latlng) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.region = region;
        this.latlng = latlng;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int[] getLatlng() {
        return latlng;
    }

    public void setLatlng(int[] latlng) {
        this.latlng = latlng;
    }
}
