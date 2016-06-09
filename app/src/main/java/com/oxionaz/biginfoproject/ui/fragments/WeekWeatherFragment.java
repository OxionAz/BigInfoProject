package com.oxionaz.biginfoproject.ui.fragments;

import android.support.v4.app.Fragment;
import com.oxionaz.biginfoproject.R;
import com.oxionaz.biginfoproject.model.DataManager;
import com.oxionaz.biginfoproject.util.UpdateCallback;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_weather_week)
public class WeekWeatherFragment extends Fragment implements UpdateCallback {

    @Override
    public void onResume() {
        super.onResume();
        DataManager.registerCallback(this);
    }

    @Override
    public void update() {

    }
}
