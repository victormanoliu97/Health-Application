package com.example.health.patientappointmentmanagement.service;

import com.example.health.patientappointmentmanagement.boundry.transferobject.AppointmentDTO;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface AppointmentService {

    String makeAppointment(AppointmentDTO appointment) throws ParseException, JSONException;

    String getPatientAppointments(Integer patientId) throws JSONException;
}
