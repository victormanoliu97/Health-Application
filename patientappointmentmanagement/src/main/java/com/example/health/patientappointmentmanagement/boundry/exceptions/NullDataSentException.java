package com.example.health.patientappointmentmanagement.boundry.exceptions;

public class NullDataSentException extends Exception {

    public NullDataSentException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NullDataSentException(String message) {
        super(message);
    }
}
