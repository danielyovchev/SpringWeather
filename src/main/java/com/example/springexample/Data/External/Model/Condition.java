package com.example.springexample.Data.External.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class Condition {
    public String text;
    public String icon;
    public int code;
}
