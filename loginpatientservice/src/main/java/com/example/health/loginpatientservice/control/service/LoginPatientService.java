package com.example.health.loginpatientservice.control.service;

import com.example.health.loginpatientservice.boundry.transferobject.PatientDTO;
import org.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public interface LoginPatientService {

    String loginPatient(PatientDTO patient) throws JSONException;
}
