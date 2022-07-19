package com.example.springexample.Domain.Service;

import com.example.springexample.API.Model.PlaceFindResponse;
import com.example.springexample.API.Model.PlaceModel;
import com.example.springexample.Data.DB.Repository.PlaceRepository;
import com.example.springexample.Domain.PlaceMapper;
import com.example.springexample.Domain.Service.Interface.PlaceFindByNameService;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class PlaceFindByNameServiceImpl implements PlaceFindByNameService {

    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;
    public PlaceFindByNameServiceImpl(PlaceRepository placeRepository, PlaceMapper placeMapper) {
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
    }

    @Override
    public PlaceFindResponse getFilteredPlace(String name) {
        return PlaceFindResponse.builder().foundPlacesList(placeRepository.findAllByName(name).stream().map(x->placeMapper.mapPlace(x)).sorted(Comparator.comparing(PlaceModel::getName).thenComparing(PlaceModel::getCountry)).toList()).build();

    }
}
