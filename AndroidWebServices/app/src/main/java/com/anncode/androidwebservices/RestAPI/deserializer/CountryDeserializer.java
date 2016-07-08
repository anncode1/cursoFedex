package com.anncode.androidwebservices.RestAPI.deserializer;

import com.anncode.androidwebservices.RestAPI.modelo.CountryResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class CountryDeserializer implements JsonDeserializer<CountryResponse> {
    @Override
    public CountryResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        return null;
    }
}
