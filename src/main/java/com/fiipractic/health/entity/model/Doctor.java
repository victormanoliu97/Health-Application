package com.fiipractic.health.entity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 40)
    private String doctorFirstName;

    @Column(name = "last_name", length = 40)
    private String doctorLastName;

    @Column(name = "function")
    private String function;

    @OneToOne(cascade = CascadeType.ALL)
    private Adress doctorAdress;

    @OneToOne(cascade = CascadeType.ALL)
    private Email doctorEmail;

    @OneToOne(cascade = CascadeType.ALL)
    private PhoneNumber doctorPhoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<Appointment> appointmentList;

    public Doctor()
    {
        appointmentList = new ArrayList<>();
    }

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
