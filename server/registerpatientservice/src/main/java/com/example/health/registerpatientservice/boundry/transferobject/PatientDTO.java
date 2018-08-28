package com.example.health.registerpatientservice.boundry.transferobject;

import com.example.health.registerpatientservice.validators.cnp_validator.CNPAnnotation;
import com.example.health.registerpatientservice.validators.email_validator.EmailAnnotation;
import com.example.health.registerpatientservice.validators.sql_injection_validator.SQLInjectionAnnotation;
import com.example.health.registerpatientservice.validators.xss_attack_validator.XSSAnnotation;

public class PatientDTO {

    @SQLInjectionAnnotation
    @XSSAnnotation
    private String firstName;

    @SQLInjectionAnnotation
    @XSSAnnotation
    private String lastName;

    @SQLInjectionAnnotation
    @XSSAnnotation
    @CNPAnnotation
    private String patientCNP;

    @SQLInjectionAnnotation
    @XSSAnnotation
    @EmailAnnotation
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatientCNP() {
        return patientCNP;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + patientCNP + " " + email;
    }
}
