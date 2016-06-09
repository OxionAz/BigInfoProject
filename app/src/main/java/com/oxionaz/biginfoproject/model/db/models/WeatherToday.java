package com.oxionaz.biginfoproject.model.db.models;

import com.oxionaz.biginfoproject.model.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;

@Table(database = AppDatabase.class)
public class WeatherToday extends BaseModel {

    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    private String location;

    @Column
    private int temp;

    @Column
    private String icon;

    @Column
    private String description;

    @Column
    private int windspeed;

    @Column
    private int humidity;

    @Column
    private int visibility;

    @Column
    private int pressure;

    @Column
    private int realfeel;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(int windspeed) {
        this.windspeed = windspeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getRealfeel() {
        return realfeel;
    }

    public void setRealfeel(int realfeel) {
        this.realfeel = realfeel;
    }
}
