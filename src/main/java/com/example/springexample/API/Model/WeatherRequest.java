package com.example.springexample.API.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class WeatherRequest {
    @JsonProperty("място")
    private String place;
    @JsonProperty("държава")
    private String country;
    @JsonDeserialize(using = WeatherRequestDeserializer.class)
    @JsonProperty("фаренхайт")
    private Boolean isFahrenheit;
}
