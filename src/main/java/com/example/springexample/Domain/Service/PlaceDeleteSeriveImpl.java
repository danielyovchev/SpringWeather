package com.example.springexample.Domain.Service;

import com.example.springexample.Data.DB.Entity.Place;
import com.example.springexample.Data.DB.Repository.PlaceRepository;
import com.example.springexample.Domain.Service.Exception.IdNotExistingException;
import com.example.springexample.Domain.Service.Interface.PlaceDeleteService;
import org.springframework.stereotype.Service;

@Service
public class PlaceDeleteSeriveImpl implements PlaceDeleteService {
    private final PlaceRepository placeRepository;

    public PlaceDeleteSeriveImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void deletePlace(Long id) throws IdNotExistingException {
        if(!placeRepository.existsById(id)){
            throw new IdNotExistingException();
        }
        placeRepository.deleteById(id);
    }
}
