package com.example.springexample.Old.Domain.Service;

import com.example.springexample.Old.Domain.interfaces.WeatherService;
import com.example.springexample.Old.Domain.model.Coordinates;
import com.example.springexample.Old.Domain.model.Weather;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class TestWeatherService implements WeatherService {
    public TestWeatherService() {
        System.out.println("Test weather service");
    }
    @Override
    public Weather getCurrentWeather(Coordinates coordinates) {
        return Weather.builder().
                location("Varna").
                degrees(18).
                humidity(35).
                description("cloudy").build();
    }
}
