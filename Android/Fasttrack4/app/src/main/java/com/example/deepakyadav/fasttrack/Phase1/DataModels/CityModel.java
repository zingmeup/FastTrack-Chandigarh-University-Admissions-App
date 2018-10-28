package com.example.deepakyadav.fasttrack.Phase1.DataModels;

import android.util.Log;

public class CityModel {
    private int cityId;
    private  String cityName;
    private String district;
    private String state;

    public CityModel(int cityId, String cityName, String district, String state) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.district = district;
        this.state = state;
        Log.e("City", cityName);
    }


    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.getCityName()+", "+this.getDistrict()+", "+this.getState();
    }
}
