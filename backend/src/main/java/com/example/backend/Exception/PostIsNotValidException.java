package com.example.backend.Exception;

public class PostIsNotValidException extends RuntimeException{
    public PostIsNotValidException(String message) {
        super(message);
    }
}
