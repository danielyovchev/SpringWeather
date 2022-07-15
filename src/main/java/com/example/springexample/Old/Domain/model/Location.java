package com.example.springexample.Old.Domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
public class Location {
    private String name;
    private Coordinates coordinates;
}
