package com.example.health.patientappointmentmanagement.boundry.transferobject;

import java.util.Date;

public class AppointmentDTO {

    private Integer idPatient;

    private String cause;

    private String speciality;

    private String startTime;

    public String getCause() {
        return cause;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getStartTime() {
        return startTime;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    @Override
    public String toString() {
        return idPatient + " " + cause + " " + speciality + " " + startTime;
    }
}
