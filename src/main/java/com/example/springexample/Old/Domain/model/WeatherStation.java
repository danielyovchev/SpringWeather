package com.example.springexample.Old.Domain.model;

import lombok.*;

@Getter @Setter(AccessLevel.PRIVATE) @Builder @ToString
public class WeatherStation {
    private String name;
    private String type;
    private float altitude;
    private float latitude;
    private float longitude;


}
