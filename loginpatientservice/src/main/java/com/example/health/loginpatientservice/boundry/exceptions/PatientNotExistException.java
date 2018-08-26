package com.example.health.loginpatientservice.boundry.exceptions;

public class PatientNotExistException extends Exception {

    public PatientNotExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public PatientNotExistException(String message) {
        super(message);
    }
}
