package com.fiipractic.health.boundry.dtos;

import com.fiipractic.health.entity.model.Adress;
import com.fiipractic.health.entity.model.Email;
import com.fiipractic.health.entity.model.PhoneNumber;


/**
 * @author Victor Manoliu on 11-Apr-18
 */
public class DoctorDTO {

    private Long doctor_id;
    private String firstName;
    private String lastName;
    private String function;
    private PhoneNumber phoneNumber;
    private Adress address;
    private Email email;

    public Long getDoctor_id() {
        return doctor_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFunction() {
        return function;
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

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFunction(String function) {
        this.function = function;
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
}
