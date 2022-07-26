package com.example.springexample.API.Model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Getter @Setter @Builder @ToString
public class WeatherResponse {
    @JsonView(Views.Public.class)
    private String place;
    @JsonView(Views.Public.class)
    private String country;
    @JsonView(Views.Internal.class)
    private String type;
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Public.class)
    private double degrees;
    @JsonView(Views.Internal.class)
    private double humidity;

}
