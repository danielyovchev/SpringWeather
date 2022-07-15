package com.example.springexample.Domain.Model;

import lombok.*;

@Getter @Setter(AccessLevel.PRIVATE) @ToString @Builder
public class Weather {
    private String location;
    private double degrees;
    private double humidity;
    private String description;

//    public Weather(String location, double degrees, double humidity, String description) {
//        this.location = location;
//        this.degrees = degrees;
//        this.humidity = humidity;
//        this.description = description;
//    }



//    public double getDegrees() {
//        return degrees;
//    }
//
//    public void setDegrees(double degrees) {
//        this.degrees = degrees;
//    }
//
//    public double getHumidity() {
//        return humidity;
//    }
//
//    public void setHumidity(double humidity) {
//        this.humidity = humidity;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "Weather{" +
//                "location: "+ location+
//                ", degrees=" + degrees +
//                ", humidity=" + humidity +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
