package com.example.health.appointmentreminderservice.boundry.transferobject;

public class ReminderDTO {

    private Integer idAppointment;

    private Integer hoursBefore;

    public Integer getIdAppointment() {
        return idAppointment;
    }

    public Integer getHoursBefore() {
        return hoursBefore;
    }

    @Override
    public String toString() {
        return idAppointment + " " + hoursBefore;
    }
}
