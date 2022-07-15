package com.example.springexample.Old.Domain.Service;

import com.example.springexample.Old.Domain.interfaces.LocationService;
import com.example.springexample.Old.Domain.model.Coordinates;
import com.example.springexample.Old.Domain.model.Location;
import com.example.springexample.Old.Exception.LocationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {
    private final Map<String, Coordinates> locationMap;

    public LocationServiceImpl() {
        locationMap = new HashMap<>();
        locationMap.put("Varna", Coordinates.builder().latitude(43).longitude(27).build());
    }

    @Override
    public void add(String label, Coordinates coordinates) {
        locationMap.put(label,coordinates);
    }

    @Override
    public Coordinates find(String label) throws LocationNotFoundException {
        if(locationMap.containsKey(label)){
            return locationMap.get(label);
        }
        else throw new LocationNotFoundException();
    }

    @Override
    public List<Location> getValidLocations() {
        List<Location> locationList = new ArrayList<>();
        this.locationMap.forEach((key, value) -> {
            locationList.add(Location.builder().name(key).
                    coordinates(value).build());
        });
        return locationList;
    }


}
