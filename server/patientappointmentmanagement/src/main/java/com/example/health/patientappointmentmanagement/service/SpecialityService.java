package com.example.health.patientappointmentmanagement.service;

import org.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public interface SpecialityService {

    String getAllSpecialities() throws JSONException;
}
