package com.fiipractic.health.boundry.dtos;

import com.fiipractic.health.entity.model.Adress;
import com.fiipractic.health.entity.model.Doctor;
import com.fiipractic.health.entity.model.Patient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Victor Manoliu on 23-Apr-18
 */
public class AppointmentDTO {

    private Long appointmentId;

    private Adress appointmentAdress;

    private Date startDate;

    private Date endDate;

    private String cause;

    private String gravity;

    private Doctor doctor;

    private Patient patient;

    private Long doctorId;

    private Long patientId;

    public Adress getAppointmentAdress() {
        return appointmentAdress;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getCause() {
        return cause;
    }

    public String getGravity() {
        return gravity;
    }

    public void setAppointmentAdress(Adress appointmentAdress) {
        this.appointmentAdress = appointmentAdress;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getDoctorId() { return doctorId; }

    public Long getPatientId() { return patientId; }
}
