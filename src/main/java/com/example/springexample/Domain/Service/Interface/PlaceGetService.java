package com.example.springexample.Domain.Service.Interface;

import com.example.springexample.API.Model.PlaceFindResponse;
import com.example.springexample.API.Model.PlaceGetResponse;
import com.example.springexample.Domain.Service.Exception.EmptyPlaceException;

public interface PlaceGetService {
    PlaceGetResponse getSelectedPlace(Long id) throws EmptyPlaceException;
    PlaceFindResponse getFilteredPlace(String name);
}
