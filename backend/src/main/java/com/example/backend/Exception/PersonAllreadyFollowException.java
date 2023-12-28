package com.example.backend.Exception;

public class PersonAllreadyFollowException extends RuntimeException{
    public PersonAllreadyFollowException(String message) {
        super(message);
    }
}
