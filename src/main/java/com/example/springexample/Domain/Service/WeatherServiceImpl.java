package com.example.springexample.Domain.Service;

import com.example.springexample.API.Model.WeatherRequest;
import com.example.springexample.API.Model.WeatherResponse;
import com.example.springexample.Data.DB.Entity.Place;
import com.example.springexample.Data.DB.Repository.PlaceRepository;
import com.example.springexample.Data.External.Model.WeatherApiResponse;
import com.example.springexample.Domain.Service.Exception.LocationNotFoundException;
import com.example.springexample.Domain.Service.Interface.RestTemplateProvider;
import com.example.springexample.Domain.Service.Interface.WeatherService;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Lazy
@Service
@Primary
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplateProvider restTemplateProvider;
    private final PlaceRepository placeRepository;
    public WeatherServiceImpl(RestTemplateProvider restTemplateProvider, PlaceRepository placeRepository) {
        this.restTemplateProvider = restTemplateProvider;
        this.placeRepository = placeRepository;
        System.out.println("Created Weather service impl");
    }

    public WeatherResponse getCurrentWeather(WeatherRequest weatherRequest) throws LocationNotFoundException {
        Place place = placeRepository.findByNameAndCountryName(weatherRequest.getPlace(), weatherRequest.getCountry());
        if(place == null) throw new LocationNotFoundException();
        final String url = "http://api.weatherapi.com/v1/current.json?key=c782585acdc84252b3790106220807&q="+place.getLatitude()+place.getLongitude();
        WeatherApiResponse weatherApiResponse = restTemplateProvider.
                getRestTemplate().
                getForObject(url, WeatherApiResponse.class);
        assert weatherApiResponse != null;
        return WeatherResponse.builder().place(place.getName()).country(place.getCountry().getName()).type(place.getType().getDescription()).
                description(weatherApiResponse.getCurrent().getCondition().getText()).
                degrees(weatherApiResponse.getCurrent().getTemp_c()).humidity(weatherApiResponse.getCurrent().getHumidity()).build();
//        return Weather.builder().
//                location(weatherApiResponse.getLocation().getName()).
//                degrees(weatherApiResponse.getCurrent().getTemp_c()).
//                humidity(weatherApiResponse.getCurrent().getHumidity()).
//                description(weatherApiResponse.getCurrent().getCondition().getText()).build();
        //return new Weather(weatherApiResponse.location.name, weatherApiResponse.current.temp_c,weatherApiResponse.current.humidity,weatherApiResponse.current.condition.text);
    }
}
