package com.example.health.patientappointmentmanagement.boundry.controller;

import com.example.health.patientappointmentmanagement.boundry.transferobject.AppointmentDTO;
import com.example.health.patientappointmentmanagement.boundry.transferobject.PatientDTO;
import com.example.health.patientappointmentmanagement.service.AppointmentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(value = "make-appointment")
    @CrossOrigin(origins = "*")
    public String makeAppointment(@RequestBody AppointmentDTO appointment) throws ParseException, JSONException {
        return appointmentService.makeAppointment(appointment);
    }

    @PostMapping(value = "patient-appointments")
    @CrossOrigin(origins = "*")
    public String getPatientAppointments(@RequestBody PatientDTO patientDTO) throws JSONException {
        return appointmentService.getPatientAppointments(patientDTO.getIdPatient());
    }
}
