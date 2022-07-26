package com.example.springexample.API.Controller;

import com.example.springexample.API.Model.Views;
import com.example.springexample.API.Model.WeatherRequest;
import com.example.springexample.API.Model.WeatherResponse;
import com.example.springexample.Domain.Service.Exception.LocationNotFoundException;
import com.example.springexample.Domain.Service.Interface.WeatherService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    /*@PostMapping("/weather")
    public String showWeather(@RequestBody WeatherRequest weatherRequest) throws LocationNotFoundException {
        return weatherService.getCurrentWeather(weatherRequest).toString();
    }*/
    @JsonView(Views.Public.class)
    @PostMapping("/weather")
    public WeatherResponse showWeather(@RequestBody WeatherRequest weatherRequest) throws LocationNotFoundException {
        return weatherService.getCurrentWeather(weatherRequest);
    }
}
