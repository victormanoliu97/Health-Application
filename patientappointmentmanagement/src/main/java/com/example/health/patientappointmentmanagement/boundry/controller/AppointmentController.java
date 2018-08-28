package com.example.health.patientappointmentmanagement.boundry.controller;

import com.example.health.patientappointmentmanagement.boundry.exceptions.NullDataSentException;
import com.example.health.patientappointmentmanagement.boundry.transferobject.AppointmentDTO;
import com.example.health.patientappointmentmanagement.service.AppointmentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String makeAppointment(@RequestBody AppointmentDTO appointment) throws ParseException, JSONException, NullDataSentException {
        if(appointment == null) {
            throw new NullDataSentException("You can't send a null body");
        }
        return appointmentService.makeAppointment(appointment);
    }

    @GetMapping(value = "patient-appointments/{patientId}")
    @CrossOrigin(origins = "*")
    public String getPatientAppointments(@PathVariable Integer patientId) throws JSONException, NullDataSentException {
        if(patientId == null) {
            throw new NullDataSentException("You can't send a null id");
        }
        return appointmentService.getPatientAppointments(patientId);
    }

    @DeleteMapping(value = "delete-appointment/{id}")
    @CrossOrigin(origins = "*")
    public String deleteAppointment(@PathVariable Integer id) throws JSONException, NullDataSentException {
        if(id == null) {
            throw new NullDataSentException("You can't send a null id");
        }
        return appointmentService.deleteAppointment(id);
    }
}
