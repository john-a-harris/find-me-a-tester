package com.umotif.findmeatester.datasource.api;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindMeATesterAPI {

    private final static String API_ENDPOINT = "http://catculator.umotif.com/catculator/";

    private static FindMeATesterAPI sApiInstance;

    private APIInterface mApiService;

    private FindMeATesterAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().create()))
                .build();

        mApiService = retrofit.create(APIInterface.class);
    }

    public static void create() {
        sApiInstance = new FindMeATesterAPI();
    }

    public static FindMeATesterAPI getInstance() {
        if (sApiInstance == null) {
            throw new NullPointerException("FindMeATesterAPI has not been initialized. Please call FindMeATesterApp.create(this); in the onCreate of FindMeATesterApp");
        }
        return sApiInstance;
    }

    public APIInterface getApiService() {
        return mApiService;
    }

}
