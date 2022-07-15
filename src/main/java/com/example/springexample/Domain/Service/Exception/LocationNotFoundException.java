package com.example.springexample.Domain.Service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "404 Error")
public class LocationNotFoundException extends Exception{

}
