package com.example.springexample.API.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class PlaceGetResponse {
    private String place;
    private String country;
    private String type;
    private double latitude;
    private double longitude;
}
