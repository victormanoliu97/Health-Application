package com.example.health.loginpatientservice.boundry.controller;

import com.example.health.loginpatientservice.boundry.exceptions.NullRequestBodyException;
import com.example.health.loginpatientservice.boundry.transferobject.PatientDTO;
import com.example.health.loginpatientservice.control.service.LoginPatientService;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPatientController {

    private final LoginPatientService loginPatientService;
    private final Logger logger = Logger.getLogger(LoginPatientController.class);

    @Autowired
    public LoginPatientController(LoginPatientService loginPatientService) {
        this.loginPatientService = loginPatientService;
    }

    @PostMapping(value = "login-patient")
    public String loginPatient(@RequestBody PatientDTO patient) throws NullRequestBodyException, JSONException {
        if(patient == null) {
            logger.debug(new NullRequestBodyException("You can't send null data"));
        }
        return loginPatientService.loginPatient(patient);
    }
}
