package com.oxionaz.biginfoproject.model.rest;

import com.oxionaz.biginfoproject.model.rest.api.WeatherAPI;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private Retrofit retrofit;

    public RestClient(){

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.worldweatheronline.com/")
                .build();
    }

    public WeatherAPI getWeatherAPI(){
        return retrofit.create(WeatherAPI.class);
    }
}
