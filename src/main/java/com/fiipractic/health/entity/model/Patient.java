package com.fiipractic.health.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_first_name", length = 40)
    private String patientFirstName;

    @Column(name = "patient_last_name", length = 60)
    private String patientLastName;

    @Column(name = "patient_age", nullable = false)
    private Long patientAge;

    private Adress patientAdress;

    private Email patientEmail;

    private PhoneNumber patientPhoneNumber;

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
}
