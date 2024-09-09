package com.semicolon.africa.hikestream.exception;

public class InvalidEmailInputException extends RuntimeException{
    public InvalidEmailInputException(String message){
        super(message);
    }
}
