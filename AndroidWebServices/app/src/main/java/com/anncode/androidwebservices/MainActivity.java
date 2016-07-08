package com.anncode.androidwebservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.anncode.androidwebservices.RestAPI.Endpoints;
import com.anncode.androidwebservices.RestAPI.adapter.RestApiAdapter;
import com.anncode.androidwebservices.RestAPI.modelo.Country;
import com.anncode.androidwebservices.RestAPI.modelo.CountryResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonAllCountries = restApiAdapter.buildGsonDeserializerAllCountries();
        Endpoints endpoints = restApiAdapter.setUpConnectionRestAPI(gsonAllCountries);
        Call<CountryResponse> countryResponseCall = endpoints.getAllCountries();



        countryResponseCall.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse countryResponse = response.body();
                countries = new ArrayList<Country>();
                countries = countryResponse.getCountries();
                for (Country country: countries) {
                    Log.e("COUNTRY NAME", country.getName());
                    Log.e("COUNTRY CODE", country.getCode());
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
