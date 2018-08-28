package com.example.health.patientappointmentmanagement.boundry.controller;

import com.example.health.patientappointmentmanagement.service.SpecialityService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;

@RestController
@CrossOrigin
public class SpecialityController {

    private final SpecialityService specialityService;

    @Autowired
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping(value = "get-all-specialities")
    @CrossOrigin(origins = "*")
    public String getAllSpecialities() throws JSONException {
        return specialityService.getAllSpecialities();
    }
}
