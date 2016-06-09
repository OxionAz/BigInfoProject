package com.oxionaz.biginfoproject.ui.fragments;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import com.oxionaz.biginfoproject.R;
import com.oxionaz.biginfoproject.model.DataManager;
import com.oxionaz.biginfoproject.model.rest.Queries;
import com.oxionaz.biginfoproject.ui.adapters.WeatherFragmentsAdapter;
import com.oxionaz.biginfoproject.util.CallbackWeather;
import com.oxionaz.biginfoproject.util.NetworkConnectionUtil;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringArrayRes;
import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_weather_main)
public class MainWeatherFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
        , CallbackWeather, ViewPager.OnPageChangeListener {

    private WeatherFragmentsAdapter weatherFragmentsAdapter;

    @Bean
    Queries queries = new Queries();

    @ViewById
    SwipeRefreshLayout refresh;

    @ViewById
    ViewPager view_pager;

    @ViewById
    PagerTabStrip view_pager_header;

    @StringArrayRes
    String[] weather_title_tabs;

    @AfterViews
    void ready(){
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new TodayWeatherFragment_());
        fragmentList.add(new HoursWeatherFragment_());
        fragmentList.add(new WeekWeatherFragment_());

        refresh.setOnRefreshListener(this);
        weatherFragmentsAdapter = new WeatherFragmentsAdapter(getActivity().getSupportFragmentManager()
                , fragmentList, weather_title_tabs);

        view_pager_header.setTabIndicatorColor(getResources().getColor(R.color.colorWhite));
        view_pager_header.setTextSize(1, 16);
        view_pager_header.setTextColor(getResources().getColor(R.color.colorWhite));
        view_pager.setAdapter(weatherFragmentsAdapter);
        view_pager.setOnPageChangeListener(this);
        DataManager.registerCallbackWeather(this);
    }

    private void tryGetData(){
        if (NetworkConnectionUtil.isNetworkConnected(getContext())){
            refresh.setRefreshing(true);
            queries.getTodayWeather();
        } else {
            Snackbar.make(view_pager, "Отсутствует интернет подключение", Snackbar.LENGTH_SHORT).show();
            refresh.setRefreshing(false);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        (weatherFragmentsAdapter.getItem(position)).onResume();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onRefresh() {
        tryGetData();
    }

    @Override
    public void endLoad() {
        refresh.setRefreshing(false);
        Snackbar.make(view_pager, "Данные загружены", Snackbar.LENGTH_SHORT).show();
    }
}
