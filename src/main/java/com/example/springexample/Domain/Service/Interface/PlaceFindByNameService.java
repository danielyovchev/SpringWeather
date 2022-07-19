package com.example.springexample.Domain.Service.Interface;

import com.example.springexample.API.Model.PlaceFindResponse;

public interface PlaceFindByNameService {
    PlaceFindResponse getFilteredPlace(String name);
}
