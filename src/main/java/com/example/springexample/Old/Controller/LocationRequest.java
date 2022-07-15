package com.example.springexample.Old.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class LocationRequest {
    private String city;
    private double latitude;
    private double longitude;

}
