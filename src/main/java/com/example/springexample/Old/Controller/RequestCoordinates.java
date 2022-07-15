package com.example.springexample.Old.Controller;

public class RequestCoordinates {

    private String longitude;
    private String latitude;

    public RequestCoordinates(String latitude, String longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
