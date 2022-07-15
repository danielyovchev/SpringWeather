package com.example.springexample.Old.Controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder @Getter
@Setter @ToString
public class WeatherStationRequest {
    private String name;
    private String type;
    private float altitude;
    private float latitude;
        private float longitude;

}
