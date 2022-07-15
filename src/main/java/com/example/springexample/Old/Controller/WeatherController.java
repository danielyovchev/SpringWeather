package com.example.springexample.Old.Controller;


import com.example.springexample.Old.Domain.WeatherMapper;
import com.example.springexample.Old.Domain.interfaces.LocationService;
import com.example.springexample.Old.Domain.interfaces.WeatherService;
import com.example.springexample.Old.Domain.model.Coordinates;
import com.example.springexample.Old.Exception.LocationNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;
    private final LocationService locationService;

    public WeatherController(WeatherService weatherService, WeatherMapper weatherMapper, LocationService locationService) {
        this.weatherService = weatherService;
        this.weatherMapper = weatherMapper;
        this.locationService = locationService;
    }

    @PostMapping("/weather")
    public String displayWeather(@RequestBody RequestCoordinates requestCoordinates){
        return weatherMapper.mapWeather(weatherService.
                getCurrentWeather(new Coordinates(Double.parseDouble(requestCoordinates.getLongitude()),
                        Double.parseDouble(requestCoordinates.getLatitude()))));
    }
    @GetMapping("/weather/forCity")
    public String getWeatherForLocation(String label) throws LocationNotFoundException {
        Coordinates coordinates = locationService.find(label);
        return weatherMapper.mapWeather(weatherService.getCurrentWeather(coordinates));
    }
}
