package com.anncode.androidwebservices.RestAPI.modelo;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class Country {

    private String code;
    private String name;
    private int area;
    private String region;
    private int lat;
    private int lng;

    public Country(int lng, int lat, String region, int area, String name, String code) {
        this.lng = lng;
        this.lat = lat;
        this.region = region;
        this.area = area;
        this.name = name;
        this.code = code;
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

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }
}
