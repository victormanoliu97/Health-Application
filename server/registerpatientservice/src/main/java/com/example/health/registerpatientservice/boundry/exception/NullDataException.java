package com.example.health.registerpatientservice.boundry.exception;

public class NullDataException extends RegisterPatientGenericException {


    public NullDataException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NullDataException(String message) {
        super(message);
    }
}
