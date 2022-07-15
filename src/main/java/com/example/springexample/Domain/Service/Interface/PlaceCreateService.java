package com.example.springexample.Domain.Service.Interface;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.API.Model.PlaceCreateResponse;
import com.example.springexample.Domain.Service.Exception.FoundException;

public interface PlaceCreateService {
    Long getCreatedPlaceId(PlaceCreateRequest placeCreateRequest) throws FoundException;
}
