package com.anncode.androidwebservices.RestAPI;

import com.anncode.androidwebservices.RestAPI.modelo.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by anahisalgado on 08/07/16.
 */
public interface Endpoints {

    @Headers({
            RestAPIConstants.HEADER_TOKEN,
            RestAPIConstants.HEADER_JSON
    })

    @GET(RestAPIConstants.KEY_ALL_COUNTRIES)
    Call<CountryResponse> getAllCountries();


}
