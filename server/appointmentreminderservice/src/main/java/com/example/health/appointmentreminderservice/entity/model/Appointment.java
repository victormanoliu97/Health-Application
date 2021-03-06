package com.example.health.appointmentreminderservice.entity.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "appointments")
public class Appointment {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_patient")
    private Integer idPatient;

    @Column(name = "id_doctor")
    private Integer idDoctor;

    @Column(name = "cause")
    private String cause;

    @Column(name = "id_speciality")
    private Integer idSpeciality;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
