package com.example.health.registerpatientservice.boundry.controller;

import com.example.health.registerpatientservice.boundry.exception.NullDataException;
import com.example.health.registerpatientservice.boundry.transferobject.PatientDTO;
import com.example.health.registerpatientservice.control.service.PatientService;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
public class RegisterPatientController {

    private final PatientService patientService;
    private final Logger logger = Logger.getLogger(RegisterPatientController.class);

    @Autowired
    public RegisterPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(value = "/register-patient")
    @CrossOrigin(origins = "*")
    public String registerPatient(@RequestBody PatientDTO patientDTO) throws JSONException, NullDataException, MessagingException {
        if(patientDTO == null) {
            logger.debug(new NullDataException("Patient body cannot be null"));
            throw new NullDataException("You can't send null data");
        }
        logger.info(patientDTO.toString());
        return patientService.savePatient(patientDTO);
    }

}
