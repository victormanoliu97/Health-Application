package com.example.health.loginpatientservice.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "patients")
public class Patient {

    @Id
    @Column(name = "id_patient")
    private Integer idPatient;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "CNP")
    private String CNP;

    @Column(name = "email")
    private String email;

    @Column(name = "login_pin")
    private Integer loginPin;

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLoginPin() {
        return loginPin;
    }

    public void setLoginPin(Integer loginPin) {
        this.loginPin = loginPin;
    }
}
