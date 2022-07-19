package com.example.springexample.Domain;

import com.example.springexample.API.Model.PlaceModel;
import com.example.springexample.Data.DB.Entity.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceMapper {
    public PlaceModel mapPlace(Place place){
        return PlaceModel.builder().name(place.getName())
                .country(place.getCountry().getName())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .type(place.getType().getDescription())
                .build();
    }
}
