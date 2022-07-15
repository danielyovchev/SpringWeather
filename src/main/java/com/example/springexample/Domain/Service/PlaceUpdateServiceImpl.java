package com.example.springexample.Domain.Service;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.Data.DB.Entity.Place;
import com.example.springexample.Data.DB.Entity.Type;
import com.example.springexample.Data.DB.Repository.PlaceRepository;
import com.example.springexample.Data.DB.Repository.TypeRepository;
import com.example.springexample.Domain.Service.Exception.EmptyPlaceException;
import com.example.springexample.Domain.Service.Interface.PlaceUpdateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceUpdateServiceImpl implements PlaceUpdateService {
    private final PlaceRepository placeRepository;
    private final TypeRepository typeRepository;
    public PlaceUpdateServiceImpl(PlaceRepository placeRepository, TypeRepository typeRepository) {
        this.placeRepository = placeRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public void updatePlace(Long id, PlaceCreateRequest placeCreateRequest) throws EmptyPlaceException {
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            throw new EmptyPlaceException();
        }
        Type type = typeRepository.findByDescription(placeCreateRequest.getType());
        place.get().setName(placeCreateRequest.getPlace());
        place.get().setTypeId(type.getId());
        placeRepository.save(place.get());
    }
}
