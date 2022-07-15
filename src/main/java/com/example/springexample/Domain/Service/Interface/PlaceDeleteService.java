package com.example.springexample.Domain.Service.Interface;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.Domain.Service.Exception.IdNotExistingException;

public interface PlaceDeleteService {
    void deletePlace(Long id) throws IdNotExistingException;
}
