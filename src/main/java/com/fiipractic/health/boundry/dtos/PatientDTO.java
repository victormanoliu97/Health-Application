package com.fiipractic.health.boundry.dtos;

import com.fiipractic.health.entity.model.Adress;
import com.fiipractic.health.entity.model.Email;
import com.fiipractic.health.entity.model.PhoneNumber;

/**
 * @author Victor Manoliu on 11-Apr-18
 */
public class PatientDTO {

    private Long patient_id;
    private String firstName;
    private String lastName;
    private Integer Age;
    private PhoneNumber phoneNumber;
    private Adress address;
    private Email email;

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Long getPatient_id() {

        return patient_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return Age;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Adress getAddress() {
        return address;
    }

    public Email getEmail() {
        return email;
    }
}
