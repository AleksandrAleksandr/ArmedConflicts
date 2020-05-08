package com.example.armedconflicts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService instance;
    private static final String BASE_URL = "https://api.acleddata.com";
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance()
    {
        if (instance == null)
            instance = new NetworkService();
        return instance;
    }

    public ApiService getJsonApi() {
        return retrofit.create(ApiService.class);
    }

}
