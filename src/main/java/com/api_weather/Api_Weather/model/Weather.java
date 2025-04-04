package com.api_weather.Api_Weather.model;

public class Weather {

    private String city;

    public Weather(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
