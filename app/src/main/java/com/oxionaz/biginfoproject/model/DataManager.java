package com.oxionaz.biginfoproject.model;

import com.oxionaz.biginfoproject.model.db.models.WeatherToday;
import com.oxionaz.biginfoproject.model.rest.models.WeatherTodayModel;
import com.oxionaz.biginfoproject.util.CallbackWeather;
import com.oxionaz.biginfoproject.util.UpdateCallback;
import com.raizlabs.android.dbflow.sql.language.SQLite;

public class DataManager {

    private static UpdateCallback updateCallback;
    private static CallbackWeather callbackWeather;

    public static void registerCallback(UpdateCallback callback){
        updateCallback = callback;
    }

    public static void registerCallbackWeather(CallbackWeather callbackW){
        callbackWeather = callbackW;
    }

    public static void saveTodayToDB(WeatherTodayModel todayModel){

        checkDB();
        WeatherToday weatherToday = new WeatherToday();
        weatherToday.setLocation(todayModel.getData().getRequest().get(0).getQuery());
        weatherToday.setTemp(Integer.parseInt(todayModel.getData().getCurrentCondition().get(0).getTempC()));
        weatherToday.setIcon(todayModel.getData().getCurrentCondition().get(0).getWeatherIconUrl().get(0).getValue());
        weatherToday.setDescription(todayModel.getData().getCurrentCondition().get(0).getLangRu().get(0).getValue());
        weatherToday.setWindspeed(Integer.parseInt(todayModel.getData().getCurrentCondition().get(0).getWindspeedKmph()));
        weatherToday.setVisibility(Integer.parseInt(todayModel.getData().getCurrentCondition().get(0).getVisibility()));
        weatherToday.setHumidity(Integer.parseInt(todayModel.getData().getCurrentCondition().get(0).getHumidity()));
        weatherToday.setPressure(Integer.parseInt(todayModel.getData().getCurrentCondition().get(0).getPressure()));
        weatherToday.setRealfeel(Integer.parseInt(todayModel.getData().getCurrentCondition().get(0).getFeelsLikeC()));
        weatherToday.save();
        update();
    }

    private static void checkDB(){
        if (!SQLite.select().from(WeatherToday.class).queryList().isEmpty()){
            SQLite.delete().from(WeatherToday.class).queryList();
        }
    }

    public static WeatherToday getTodayWeather(){
        return SQLite.select().from(WeatherToday.class).querySingle();
    }

    private static void update(){
        updateCallback.update();
        callbackWeather.endLoad();
    }
}