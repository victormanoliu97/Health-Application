package com.example.health.patientappointmentmanagement.entity.model;

import javax.persistence.*;

@Entity(name = "specialities")
public class Speciality {

    @Column(name = "id_speciality")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSpeciality;

    @Column(name = "name")
    private String name;

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Integer idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
