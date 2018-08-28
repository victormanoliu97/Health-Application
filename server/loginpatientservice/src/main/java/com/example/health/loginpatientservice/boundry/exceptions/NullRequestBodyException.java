package com.example.health.loginpatientservice.boundry.exceptions;

public class NullRequestBodyException extends Exception {

    public NullRequestBodyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NullRequestBodyException(String message) {
        super(message);
    }
}
