package com.example.springexample.Domain.Service.Interface;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.Domain.Service.Exception.EmptyPlaceException;

public interface PlaceUpdateService {
    void updatePlace(Long id, PlaceCreateRequest placeCreateRequest) throws EmptyPlaceException;
}
