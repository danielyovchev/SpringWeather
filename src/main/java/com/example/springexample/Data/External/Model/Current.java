package com.example.springexample.Data.External.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Current {
    public int last_updated_epoch;
    public String last_updated;
    public double temp_c;
    public double temp_f;
    public int is_day;
    public double wind_mph;
    public double wind_kph;
    public int wind_degree;
    public String wind_dir;
    public double pressure_mb;
    public double pressure_in;
    public double precip_mm;
    public double precip_in;
    public int humidity;
    public int cloud;
    public Condition condition;
    public double feelslike_c;
    public double feelslike_f;
    public double vis_km;
    public double vis_miles;
    public double uv;
    public double gust_mph;
    public double gust_kph;
}
