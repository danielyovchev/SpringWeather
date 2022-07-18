package com.example.springexample.API.Model;


import lombok.*;

import java.util.List;
@Getter @Setter(AccessLevel.PRIVATE) @Builder @ToString
public class PlaceFindResponse {
    private List<String> foundPlacesList;
}
