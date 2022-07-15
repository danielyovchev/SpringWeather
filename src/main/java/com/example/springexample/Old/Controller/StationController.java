package com.example.springexample.Old.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {
    @PostMapping("/station")
    public String showStation(@RequestBody WeatherStationRequest weatherStationRequest){
        return weatherStationRequest.toString();
    }
}
