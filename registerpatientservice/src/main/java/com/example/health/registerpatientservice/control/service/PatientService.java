package com.example.health.registerpatientservice.control.service;

import com.example.health.registerpatientservice.boundry.transferobject.PatientDTO;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface PatientService {

    String savePatient(PatientDTO patient) throws JSONException, MessagingException;

    Integer generateLoginPin();

    boolean patientAlreadyExists(PatientDTO patient);

    void sendEmail(PatientDTO patient) throws MessagingException;

}
