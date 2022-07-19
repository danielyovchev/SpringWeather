package com.example.springexample.API.Model;

import lombok.*;

@Getter @Setter(AccessLevel.PRIVATE) @Builder @ToString
public class PlaceModel {
    private String name;
    private String country;
    private double latitude;
    private double longitude;
    private String type;
}
