package com.fiipractic.health.entity.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Victor Manoliu on 10-Apr-18
 */
@Entity
@Table(name = "appoinments")
public class Appointment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @OneToOne(cascade = CascadeType.ALL)
    private Adress appointmentAdress;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "cause")
    private String cause;

    @Column(name = "gravity")
    private String gravity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

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
}
