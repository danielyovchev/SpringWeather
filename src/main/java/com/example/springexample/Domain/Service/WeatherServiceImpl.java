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

import java.util.Objects;
import java.util.stream.Stream;

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
        return Stream.of(place)
                .map(x -> restTemplateProvider.getRestTemplate().getForObject(url, WeatherApiResponse.class))
                .filter(Objects::nonNull)
                .map(x -> WeatherResponse.builder()
                        .place(place.getName())
                        .country(place.getCountry().getName())
                        .type(place.getType().getDescription())
                        .description(x.getCurrent().getCondition().getText())
                        .degrees(x.getCurrent().getTemp_c())
                        .humidity(x.getCurrent().getHumidity()).build())
                .peek(x -> {
                    if(weatherRequest.isFahrenheit()){
                        x.setDegrees((x.getDegrees()*9/5)+32);
                    }
                })
                .toList()
                .stream()
                .findFirst()
                .get();
//        WeatherApiResponse weatherApiResponse = restTemplateProvider.
//                getRestTemplate().
//                getForObject(url, WeatherApiResponse.class);
//        assert weatherApiResponse != null;
//        double temperature = weatherApiResponse.getCurrent().getTemp_c();
//        boolean flag = weatherRequest.isFahrenheit();
//        if(flag){
//            temperature = (weatherApiResponse.getCurrent().getTemp_c()*9/5)+32;
//        }
//        return WeatherResponse.builder().place(place.getName()).country(place.getCountry().getName()).type(place.getType().getDescription()).
//                description(weatherApiResponse.getCurrent().getCondition().getText()).
//                degrees(temperature).humidity(weatherApiResponse.getCurrent().getHumidity()).build();
    }
}
