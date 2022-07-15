package com.example.springexample.API.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class PlaceCreateRequest {
    private String place;
    private String country;
    private String type;
    private double latitude;
    private double longitude;
}
