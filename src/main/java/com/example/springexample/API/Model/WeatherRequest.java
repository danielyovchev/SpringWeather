package com.example.springexample.API.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class WeatherRequest {
    private String place;
    private String country;
}
