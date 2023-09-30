package com.travel.mintp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegionNotFoundExeption extends RuntimeException {

    public RegionNotFoundExeption(String message){
        super(message);
    }
}
