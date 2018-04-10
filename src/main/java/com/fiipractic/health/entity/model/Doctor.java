package com.fiipractic.health.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private Adress doctorAdress;

    private Email doctorEmail;

    private PhoneNumber doctorPhoneNumber;

}
