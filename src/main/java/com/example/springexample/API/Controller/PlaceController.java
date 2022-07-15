package com.example.springexample.API.Controller;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.API.Model.PlaceCreateResponse;
import com.example.springexample.Domain.Service.Exception.FoundException;
import com.example.springexample.Domain.Service.Interface.PlaceCreateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    private final PlaceCreateService placeCreateService;

    public PlaceController(PlaceCreateService placeCreateService) {
        this.placeCreateService = placeCreateService;
    }
    @PostMapping("/add")
    public Long showCreatedPlaceId(@RequestBody PlaceCreateRequest placeCreateRequest) throws FoundException {
        return placeCreateService.getCreatedPlaceId(placeCreateRequest);
    }

}
