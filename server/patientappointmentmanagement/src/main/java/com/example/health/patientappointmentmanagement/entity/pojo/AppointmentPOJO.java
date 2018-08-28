package com.example.health.patientappointmentmanagement.entity.pojo;

import java.util.Date;

public class AppointmentPOJO {

    private String doctorFirstName;

    private String doctorLastName;

    private String doctorEmail;

    private String appointmentCause;

    private String specialityName;

    private Date starTime;

    private Date endTime;

    private Integer appointmentId;

    public AppointmentPOJO() {

    }

    public AppointmentPOJO(String doctorFirstName, String doctorLastName,
                           String doctorEmail, String appointmentCause,
                           String specialityName, Date starTime, Date endTime,
                            Integer appointmentId) {
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.doctorEmail = doctorEmail;
        this.appointmentCause = appointmentCause;
        this.specialityName = specialityName;
        this.starTime = starTime;
        this.endTime = endTime;
        this.appointmentId = appointmentId;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public String getAppointmentCause() {
        return appointmentCause;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public Date getStarTime() {
        return starTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

}
