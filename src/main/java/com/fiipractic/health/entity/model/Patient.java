package com.fiipractic.health.entity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_first_name", length = 40)
    private String patientFirstName;

    @Column(name = "patient_last_name", length = 60)
    private String patientLastName;

    @Column(name = "patient_age", length = 20)
    private Long patientAge;

    @OneToOne(cascade = CascadeType.ALL)
    private Adress patientAdress;

    @OneToOne(cascade = CascadeType.ALL)
    private Email patientEmail;

    @OneToOne(cascade = CascadeType.ALL)
    private PhoneNumber patientPhoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Appointment> appointmentList;

    public Patient()
    {
        appointmentList = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientAge(Long patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public void setPatientAdress(Adress patientAdress) {
        this.patientAdress = patientAdress;
    }

    public void setPatientEmail(Email patientEmail) {
        this.patientEmail = patientEmail;
    }

    public void setPatientPhoneNumber(PhoneNumber patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientAge() {
        return patientAge;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public Adress getPatientAdress() {
        return patientAdress;
    }

    public Email getPatientEmail() {
        return patientEmail;
    }

    public PhoneNumber getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }
}
