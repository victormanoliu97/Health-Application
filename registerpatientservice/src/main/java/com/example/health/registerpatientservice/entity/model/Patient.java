package com.example.health.registerpatientservice.entity.model;

import javax.persistence.*;

@Entity(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCNP() {
        return CNP;
    }

    public String getEmail() {
        return email;
    }

    public Integer getLoginPin() {
        return loginPin;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoginPin(Integer loginPin) {
        this.loginPin = loginPin;
    }
}
