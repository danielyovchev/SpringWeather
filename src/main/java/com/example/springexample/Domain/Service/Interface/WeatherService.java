package com.example.springexample.Domain.Service.Interface;

import com.example.springexample.API.Model.WeatherRequest;
import com.example.springexample.API.Model.WeatherResponse;
import com.example.springexample.Domain.Model.Coordinates;
import com.example.springexample.Domain.Model.Weather;
import com.example.springexample.Domain.Service.Exception.LocationNotFoundException;


public interface WeatherService {
    WeatherResponse getCurrentWeather(WeatherRequest weatherRequest) throws LocationNotFoundException;
}
