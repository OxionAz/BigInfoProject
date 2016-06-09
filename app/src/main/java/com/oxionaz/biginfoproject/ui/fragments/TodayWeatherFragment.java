package com.oxionaz.biginfoproject.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.widget.ImageView;
import android.widget.TextView;
import com.oxionaz.biginfoproject.R;
import com.oxionaz.biginfoproject.model.DataManager;
import com.oxionaz.biginfoproject.model.db.models.WeatherToday;
import com.oxionaz.biginfoproject.util.UpdateCallback;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

@EFragment(R.layout.fragment_weather_today)
public class TodayWeatherFragment extends Fragment implements UpdateCallback {

    @ViewById
    ImageView weather_icon;

    @ViewById
    TextView weather_description, weather_temp, weather_realfeel_value, weather_humidity_value, weather_windspeed_value
            ,weather_visibility_value, weather_pressure_value;

    @StringRes
    String description_value, temp_value, realfeel_value, humidity_value, windspeed_value
            ,visibility_value, pressure_value;

    @Override
    public void onResume() {
        super.onResume();
        DataManager.registerCallback(this);
        updateData();
    }

    private void updateData(){
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<WeatherToday>() {
            @Override
            public Loader<WeatherToday> onCreateLoader(int id, Bundle args) {
                AsyncTaskLoader<WeatherToday> loader = new AsyncTaskLoader<WeatherToday>(getContext()) {
                    @Override
                    public WeatherToday loadInBackground() {
                        return DataManager.getTodayWeather();
                    }
                };
                loader.forceLoad();
                return loader;
            }

            @Override
            public void onLoadFinished(Loader<WeatherToday> loader, WeatherToday data) {
                setData(data);
            }

            @Override
            public void onLoaderReset(Loader<WeatherToday> loader) {

            }
        });
    }

    private void setData(WeatherToday weatherToday){
        getActivity().setTitle(weatherToday.getLocation());
        weather_description.setText(String.format(description_value, weatherToday.getDescription()));
        weather_temp.setText(String.format(temp_value, weatherToday.getTemp()));
        weather_realfeel_value.setText(String.format(realfeel_value, weatherToday.getRealfeel()));
        weather_humidity_value.setText(String.format(humidity_value, weatherToday.getHumidity() + "%"));
        weather_windspeed_value.setText(String.format(windspeed_value, weatherToday.getWindspeed()));
        weather_visibility_value.setText(String.format(visibility_value, weatherToday.getVisibility()));
        weather_pressure_value.setText(String.format(pressure_value, weatherToday.getTemp()));
    }

    @Override
    public void update() {
        updateData();
    }
}
