package com.anncode.androidwebservices.RestAPI.adapter;

import com.anncode.androidwebservices.RestAPI.Endpoints;
import com.anncode.androidwebservices.RestAPI.RestAPIConstants;
import com.google.gson.Gson;

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



}
