package com.example.springexample.Domain.Model;

import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @ToString
public class Coordinates {
    private double longitude;
    private double latitude;

//    public Coordinates(double latitude, double longitude) {
//        this.longitude = longitude;
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    @Override
//    public String toString() {
//        return "Coordinates: " +
//                "latitude=" + latitude +
//                "longitude=" + longitude +
//                '}';
//    }
}
