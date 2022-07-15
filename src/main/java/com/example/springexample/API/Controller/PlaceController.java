package com.example.springexample.API.Controller;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.Domain.Service.Exception.FoundException;
import com.example.springexample.Domain.Service.Exception.IdNotExistingException;
import com.example.springexample.Domain.Service.Interface.PlaceCreateService;
import com.example.springexample.Domain.Service.Interface.PlaceDeleteService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceController {
    private final PlaceCreateService placeCreateService;
    private final PlaceDeleteService placeDeleteService;
    public PlaceController(PlaceCreateService placeCreateService, PlaceDeleteService placeDeleteService) {
        this.placeCreateService = placeCreateService;
        this.placeDeleteService = placeDeleteService;
    }
    @PostMapping("/add")
    public Long showCreatedPlaceId(@RequestBody PlaceCreateRequest placeCreateRequest) throws FoundException {
        return placeCreateService.getCreatedPlaceId(placeCreateRequest);
    }

    @DeleteMapping
    public void deletePlace(@RequestParam Long id) throws IdNotExistingException {
        placeDeleteService.deletePlace(id);
    }
    
}
