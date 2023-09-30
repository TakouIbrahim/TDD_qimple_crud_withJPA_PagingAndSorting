package com.travel.mintp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundExeption extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public RessourceNotFoundExeption(String message){
        super(message);
    }
}
