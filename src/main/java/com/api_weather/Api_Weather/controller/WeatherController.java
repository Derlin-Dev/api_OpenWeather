package com.api_weather.Api_Weather.controller;

import com.api_weather.Api_Weather.exception.ResourceNotFoundException;
import com.api_weather.Api_Weather.model.Weather;
import com.api_weather.Api_Weather.services.WeatherServices;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherServices weatherServices;

    public WeatherController(WeatherServices weatherServices) {
        this.weatherServices = weatherServices;
    }

    @PostMapping("/city")
    public ResponseEntity<?> getWeather(@RequestBody Weather city)
            throws IOException, InterruptedException, JSONException,ResourceNotFoundException
    {
        Map<String, Object> weather = weatherServices.getWeather(city);
        return ResponseEntity.ok(weather);
    }

//    @GetMapping("/test")
//    public ResponseEntity<?> test()
//            throws IOException, InterruptedException, JSONException//,ResourceNotFoundException
//    {
//        Map<String, Object> weather = weatherServices.test();
//        return ResponseEntity.ok(weather);
//    }


}
