package com.bored.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BoredException extends RuntimeException{
    private HttpStatus status;

    public BoredException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
