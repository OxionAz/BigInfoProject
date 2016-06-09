package com.oxionaz.biginfoproject.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.oxionaz.biginfoproject.R;
import com.oxionaz.biginfoproject.ui.fragments.MainWeatherFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawer;

    @ViewById(R.id.nav_view)
    NavigationView navigationView;

    @AfterViews
    void ready(){
        setToolbarAndDrawer();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MainWeatherFragment_()).commit();
    }

    private void setToolbarAndDrawer(){
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()) {
            case R.id.nav_weather:
                fragmentManager.beginTransaction().replace(R.id.main_frame, new MainWeatherFragment_()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}