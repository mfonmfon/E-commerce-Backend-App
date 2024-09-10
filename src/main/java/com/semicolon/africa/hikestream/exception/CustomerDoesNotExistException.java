package com.semicolon.africa.hikestream.exception;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(String message) {
        super(message);
    }
}
