package com.travel.mintp.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }


    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

   

}
