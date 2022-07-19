package com.example.springexample.API.Controller;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.Domain.Service.Exception.EmptyPlaceException;
import com.example.springexample.Domain.Service.Exception.FoundException;
import com.example.springexample.Domain.Service.Exception.IdNotExistingException;
import com.example.springexample.Domain.Service.Interface.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceController {
    private final PlaceCreateService placeCreateService;
    private final PlaceDeleteService placeDeleteService;
    private final PlaceUpdateService placeUpdateService;
    private final PlaceGetService placeGetService;
    private final PlaceFindByNameService placeFindByNameService;
    public PlaceController(PlaceCreateService placeCreateService, PlaceDeleteService placeDeleteService, PlaceUpdateService placeUpdateService, PlaceGetService placeGetService, PlaceFindByNameService placeFindByNameService) {
        this.placeCreateService = placeCreateService;
        this.placeDeleteService = placeDeleteService;
        this.placeUpdateService = placeUpdateService;
        this.placeGetService = placeGetService;
        this.placeFindByNameService = placeFindByNameService;
    }
    @PostMapping("/add")
    public Long showCreatedPlaceId(@RequestBody PlaceCreateRequest placeCreateRequest) throws FoundException {
        return placeCreateService.getCreatedPlaceId(placeCreateRequest).getId();
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
    @GetMapping("/getByName")
    public String showPlaceByName(@RequestParam String name){
        return placeFindByNameService.getFilteredPlace(name).toString();
        //return placeGetService.getFilteredPlace(name).toString();
    }
}
