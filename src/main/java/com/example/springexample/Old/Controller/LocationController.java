package com.example.springexample.Old.Controller;

import com.example.springexample.Old.Domain.interfaces.LocationService;
import com.example.springexample.Old.Domain.model.Coordinates;
import com.example.springexample.Old.Domain.model.Location;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping("/location")
    public void addLocation(@RequestBody LocationRequest locationRequest){
        Coordinates coordinates = new Coordinates(locationRequest.getLatitude(), locationRequest.getLongitude());
        locationService.add(locationRequest.getCity(), coordinates);
    }
    @PostMapping("/location/printAll")
    public List<Location> getValidLocation(){
        return locationService.getValidLocations();
    }

}
