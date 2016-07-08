package com.anncode.androidwebservices.RestAPI.adapter;

import com.anncode.androidwebservices.RestAPI.Endpoints;
import com.anncode.androidwebservices.RestAPI.RestAPIConstants;
import com.anncode.androidwebservices.RestAPI.deserializer.CountryDeserializer;
import com.anncode.androidwebservices.RestAPI.modelo.CountryResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class RestApiAdapter {

    public Endpoints setUpConnectionRestAPI(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestAPIConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                ;

        return retrofit.create(Endpoints.class);

    }

    public Gson buildGsonDeserializerAllCountries(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CountryResponse.class,
                new CountryDeserializer());
        return gsonBuilder.create();
    }


}
