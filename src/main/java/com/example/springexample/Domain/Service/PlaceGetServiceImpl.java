package com.example.springexample.Domain.Service;

import com.example.springexample.API.Model.PlaceFindResponse;
import com.example.springexample.API.Model.PlaceGetResponse;
import com.example.springexample.Data.DB.Entity.Place;
import com.example.springexample.Data.DB.Repository.PlaceRepository;
import com.example.springexample.Domain.Service.Exception.EmptyPlaceException;
import com.example.springexample.Domain.Service.Interface.PlaceGetService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PlaceGetServiceImpl implements PlaceGetService {
    private final PlaceRepository placeRepository;

    public PlaceGetServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public PlaceGetResponse getSelectedPlace(Long id) throws EmptyPlaceException {
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            throw new EmptyPlaceException();
        }
        return PlaceGetResponse.builder().place(place.get().getName()).country(place.get().getCountry().getName()).
                type(place.get().getType().getDescription()).latitude(place.get().getLatitude()).longitude(place.get().getLongitude()).build();
    }

    /*@Override
    public PlaceFindResponse getFilteredPlace(String name) {
        return PlaceFindResponse.builder().foundPlacesList(placeRepository.findAllByName(name).stream().map(x -> x.toString()).toList()).build();
    }*/

}
