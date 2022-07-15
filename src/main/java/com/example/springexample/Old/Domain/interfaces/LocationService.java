package com.example.springexample.Old.Domain.interfaces;

import com.example.springexample.Old.Domain.model.Coordinates;
import com.example.springexample.Old.Domain.model.Location;
import com.example.springexample.Old.Exception.LocationNotFoundException;

import java.util.List;

public interface LocationService {
    void add(String label, Coordinates coordinates);
    Coordinates find(String label) throws LocationNotFoundException;
    List<Location> getValidLocations();
}
