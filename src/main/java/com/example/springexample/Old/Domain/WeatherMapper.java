package com.example.springexample.Old.Domain;

import com.example.springexample.Old.Domain.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class WeatherMapper {
    public String mapWeather(Weather weather){
        return weather.toString();
    }
}
