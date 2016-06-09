package com.oxionaz.biginfoproject.model.rest;

import com.oxionaz.biginfoproject.model.DataManager;
import com.oxionaz.biginfoproject.model.rest.models.WeatherTodayModel;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@EBean
public class Queries {

    private RestClient restClient = new RestClient();

    @Background
    public void getTodayWeather(){

        Observable<WeatherTodayModel> today = restClient
                .getWeatherAPI().getTodayWeather("ea860fc4f49d4371ba1220416160606","Minsk");

        today.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(DataManager::saveTodayToDB);
    }
}