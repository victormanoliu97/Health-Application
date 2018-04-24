package com.fiipractic.health.control.service;

import com.fiipractic.health.entity.model.Appointment;
import com.fiipractic.health.entity.model.Doctor;
import com.fiipractic.health.entity.model.Patient;

import java.util.Date;
import java.util.List;

/**
 * @author Victor Manoliu on 11-Apr-18
 */
public interface AppointmentService {

    List<Appointment> getAppointments();

    Appointment getAppointment(Long appointmentId);

    void deleteAppointment(Appointment appointment);

    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAppointmentByPatient(Long patientId);

    List<Appointment> getAppointmentByDoctor(Long doctorId);

    Appointment getById(Long id);

}
