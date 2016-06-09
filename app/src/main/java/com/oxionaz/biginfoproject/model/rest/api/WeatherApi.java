package com.oxionaz.biginfoproject.model.rest.api;

import com.oxionaz.biginfoproject.model.rest.models.WeatherTodayModel;
import com.oxionaz.biginfoproject.model.rest.models.WeatherWeekModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherAPI {

    @GET("premium/v1/weather.ashx?format=json&date=today&fx=no&mca=no&lang=ru")
    Observable<WeatherTodayModel> getTodayWeather(@Query("key") String key, @Query("q") String city);

    @GET("premium/v1/weather.ashx?format=json&num_of_days=7&cc=no&mca=no&tp=24&lang=ru")
    Observable<WeatherWeekModel> getWeekWeather(@Query("key") String key, @Query("q") String city);
}
