package com.anncode.androidwebservices.RestAPI.deserializer;

import com.anncode.androidwebservices.RestAPI.JsonKeys;
import com.anncode.androidwebservices.RestAPI.modelo.Country;
import com.anncode.androidwebservices.RestAPI.modelo.CountryResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by anahisalgado on 08/07/16.
 */
public class CountryDeserializer implements JsonDeserializer<CountryResponse> {
    @Override
    public CountryResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray array = json.getAsJsonArray();
        Iterator<JsonElement> iterator = array.iterator();
        Gson gson = new Gson();
        CountryResponse countryResponse = null;
        countryResponse.setCountries(deserializerCountryJson(array));
        /*while (iterator.hasNext()){
            JsonElement json2 = (JsonElement) iterator.next();
            countryResponse = gson.fromJson(json2, CountryResponse.class);
            JsonObject countryResponseData = json2.getAsJsonObject();
            countryResponse.setCountries(deserializerCountryJson(countryResponseData));
        }*/
 




        //CountryResponse countryResponse = new CountryResponse();
        //JsonArray countryResponseData = json.getAsJsonArray();
        //countryResponse.setCountries(deserializerCountryJson(countryResponseData));

        return countryResponse;
    }


    private ArrayList<Country> deserializerCountryJson(JsonArray countryResponseData){
        ArrayList<Country> countries = new ArrayList<>();

        for (int i = 0; i < countryResponseData.size(); i++) {
            JsonObject countryResponseObject = countryResponseData.get(i).getAsJsonObject();
            String  code     = countryResponseObject.get(JsonKeys.COUNTRY_CODE).getAsString();
            String  name     = countryResponseObject.get(JsonKeys.COUNTRY_NAME).getAsString();
            int     area     = countryResponseObject.get(JsonKeys.COUNTRY_AREA).getAsInt();
            String  region   = countryResponseObject.get(JsonKeys.COUNTRY_REGION).getAsString();

            JsonArray latlng = countryResponseObject.getAsJsonArray(JsonKeys.COUNTRY_LATLNG);
            int lat = latlng.get(0).getAsInt();
            int lng = latlng.get(1).getAsInt();

            countries.add(new Country(lng,lat,region,area,name,code));
        }

        return countries;

    }
}
