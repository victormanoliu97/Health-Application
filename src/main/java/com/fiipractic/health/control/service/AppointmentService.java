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

    List<Appointment> getAppointmentByPatient(Patient patient);

    List<Appointment> getAppointmentByDoctor(Doctor doctor);

    List<Appointment> getAllApointmentsByDoctorEndTimeGreater(Doctor doctor, Date endDate);

    List<Appointment> getAllApointmentsByEndTimeGreater(Date endDate);
}
