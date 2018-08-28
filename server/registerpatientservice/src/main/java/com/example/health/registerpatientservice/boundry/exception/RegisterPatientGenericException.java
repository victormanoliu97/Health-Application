package com.example.health.registerpatientservice.boundry.exception;

public class RegisterPatientGenericException extends Exception {

    public RegisterPatientGenericException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RegisterPatientGenericException(String message) {
        super(message);
    }
}
