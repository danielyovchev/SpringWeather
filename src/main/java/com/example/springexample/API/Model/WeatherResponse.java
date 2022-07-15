package com.example.springexample.API.Model;

import lombok.*;

@Getter @Setter(AccessLevel.PRIVATE) @Builder @ToString
public class WeatherResponse {
    private String place;
    private String country;
    private String type;
    private String description;
    private double degrees;
    private double humidity;
}
