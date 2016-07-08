package com.anncode.androidwebservices.RestAPI.modelo;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class CountryResponse {

    ArrayList<Country> countries;

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
}
