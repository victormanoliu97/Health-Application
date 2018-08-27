package com.example.health.patientappointmentmanagement.entity.pojo;

public class SpecialityPOJO {

    private Integer idSpeciality;

    private String name;

    public SpecialityPOJO() {

    }

    public SpecialityPOJO(Integer idSpeciality, String name) {
        this.idSpeciality = idSpeciality;
        this.name = name;
    }

    public Integer getIdSpeciality() {
        return idSpeciality;
    }

    public String getName() {
        return name;
    }
}
