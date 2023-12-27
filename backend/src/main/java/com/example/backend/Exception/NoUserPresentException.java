package com.example.backend.Exception;

public class NoUserPresentException extends RuntimeException{

    public NoUserPresentException(String message) {
        super(message);
    }
}
