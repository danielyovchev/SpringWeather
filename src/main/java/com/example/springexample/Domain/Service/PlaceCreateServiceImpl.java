package com.example.springexample.Domain.Service;

import com.example.springexample.API.Model.PlaceCreateRequest;
import com.example.springexample.API.Model.PlaceCreateResponse;
import com.example.springexample.Data.DB.Entity.Country;
import com.example.springexample.Data.DB.Entity.Place;
import com.example.springexample.Data.DB.Entity.Type;
import com.example.springexample.Data.DB.Repository.CountryRepository;
import com.example.springexample.Data.DB.Repository.PlaceRepository;
import com.example.springexample.Data.DB.Repository.TypeRepository;
import com.example.springexample.Domain.Service.Exception.FoundException;
import com.example.springexample.Domain.Service.Interface.PlaceCreateService;
import org.springframework.stereotype.Service;

@Service
public class PlaceCreateServiceImpl implements PlaceCreateService {
    private final CountryRepository countryRepository;
    private final TypeRepository typeRepository;
    private final PlaceRepository placeRepository;

    public PlaceCreateServiceImpl(CountryRepository countryRepository, TypeRepository typeRepository, PlaceRepository placeRepository) {
        this.countryRepository = countryRepository;
        this.typeRepository = typeRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public Long getCreatedPlaceId(PlaceCreateRequest placeCreateRequest) throws FoundException {
        Type type = typeRepository.findByDescription(placeCreateRequest.getType());
        Country country = countryRepository.findByName(placeCreateRequest.getCountry());
        Place place = placeRepository.findByNameAndCountryName(placeCreateRequest.getPlace(), placeCreateRequest.getCountry());
        if(place != null){
            throw new FoundException();
        }
        if(type == null){
            type = new Type();
            type.setDescription(placeCreateRequest.getType());
            typeRepository.save(type);
        }
        if(country == null){
            country = new Country();
            country.setName(placeCreateRequest.getCountry());
            countryRepository.save(country);
        }
        place = new Place();
        place.setName(placeCreateRequest.getPlace());
        place.setCountryId(country.getId());
        place.setTypeId(type.getId());
        place.setLatitude(placeCreateRequest.getLatitude());
        place.setLongitude(placeCreateRequest.getLongitude());
        placeRepository.save(place);

        return place.getId();
    }
}
