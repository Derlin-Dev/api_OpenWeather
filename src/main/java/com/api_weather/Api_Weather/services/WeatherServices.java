package com.api_weather.Api_Weather.services;

import com.api_weather.Api_Weather.exception.ResourceNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import com.api_weather.Api_Weather.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherServices {

    @Value("${api.key}")
    private String key;

    Map<String, Object> response;

    public Map<String, Object> getWeather(Weather weather)
            throws IOException, InterruptedException, JSONException, ResourceNotFoundException
    {
        String city = weather.getCity();
        String cityFormat = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String stringUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityFormat +"&APPID=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(stringUrl))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        String responseCode = String.valueOf(json.getInt("cod"));

        if(responseCode.equals("200")){
            JSONObject main = json.getJSONObject("main");
            double temp = main.getDouble("temp");
            int humidity = main.getInt("humidity");
            String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
            return jsonReturn(city, temp, humidity, description);
        }
        throw new ResourceNotFoundException("Error al solicitar los datos");
    }

    public Map<String, Object> jsonReturn(String city, double temp, int humidity, String description){
        response = new HashMap<>();
        response.put("ciudad", city);
        response.put("descripcion", description);
        response.put("humedad", humidity);
        response.put("temperatura", temp);

        return response;
    }

}
