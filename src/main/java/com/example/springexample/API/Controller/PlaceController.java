package com.example.springexample.API.Controller;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.Domain.Service.Exception.EmptyPlaceException;
import com.example.springexample.Domain.Service.Exception.FoundException;
import com.example.springexample.Domain.Service.Exception.IdNotExistingException;
import com.example.springexample.Domain.Service.Interface.PlaceCreateService;
import com.example.springexample.Domain.Service.Interface.PlaceDeleteService;
import com.example.springexample.Domain.Service.Interface.PlaceGetService;
import com.example.springexample.Domain.Service.Interface.PlaceUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceController {
    private final PlaceCreateService placeCreateService;
    private final PlaceDeleteService placeDeleteService;
    private final PlaceUpdateService placeUpdateService;
    private final PlaceGetService placeGetService;
    public PlaceController(PlaceCreateService placeCreateService, PlaceDeleteService placeDeleteService, PlaceUpdateService placeUpdateService, PlaceGetService placeGetService) {
        this.placeCreateService = placeCreateService;
        this.placeDeleteService = placeDeleteService;
        this.placeUpdateService = placeUpdateService;
        this.placeGetService = placeGetService;
    }
    @PostMapping("/add")
    public Long showCreatedPlaceId(@RequestBody PlaceCreateRequest placeCreateRequest) throws FoundException {
        return placeCreateService.getCreatedPlaceId(placeCreateRequest);
    }

    @DeleteMapping("/delete")
    public void deletePlace(@RequestParam Long id) throws IdNotExistingException {
        placeDeleteService.deletePlace(id);
    }

    @PutMapping("/update")
    public void updatePlace(@RequestParam Long id, @RequestBody PlaceCreateRequest placeCreateRequest) throws EmptyPlaceException {
        placeUpdateService.updatePlace(id, placeCreateRequest);
    }
    @GetMapping("/get")
    public String showPlace(@RequestParam Long id) throws EmptyPlaceException {
        return placeGetService.getSelectedPlace(id).toString();
    }
}
