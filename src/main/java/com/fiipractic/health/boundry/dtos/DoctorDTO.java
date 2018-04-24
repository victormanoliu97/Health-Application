package com.fiipractic.health.boundry.dtos;

import com.fiipractic.health.entity.model.Adress;
import com.fiipractic.health.entity.model.Appointment;
import com.fiipractic.health.entity.model.Email;
import com.fiipractic.health.entity.model.PhoneNumber;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Victor Manoliu on 11-Apr-18
 */
public class DoctorDTO {

    private Long id;

    private String doctorFirstName;

    private String doctorLastName;

    private String function;

    private Adress doctorAdress;

    private Email doctorEmail;

    private PhoneNumber doctorPhoneNumber;

    private List<Appointment> appointmentList;

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public Long getId() {
        return id;
    }

    public String getFunction() {
        return function;
    }

    public Adress getDoctorAdress() {
        return doctorAdress;
    }

    public Email getDoctorEmail() {
        return doctorEmail;
    }

    public PhoneNumber getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setDoctorAdress(Adress doctorAdress) {
        this.doctorAdress = doctorAdress;
    }

    public void setDoctorEmail(Email doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public void setDoctorPhoneNumber(PhoneNumber doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }
}
