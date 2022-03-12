package com.odev.asaver.exception;

import lombok.Getter;

import java.util.List;

public class ASaverException extends RuntimeException{

    @Getter
    private List<String> errors;

    public ASaverException(String message){
        super(message);
    }

    public ASaverException(String message, List<String> errors){
        super(message);
        this.errors = errors;
    }
}
