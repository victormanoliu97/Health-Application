package com.fiipractic.health.control.service;

import com.fiipractic.health.entity.model.Appointment;
import com.fiipractic.health.entity.model.Doctor;
import com.fiipractic.health.entity.model.Patient;
import com.fiipractic.health.entity.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Victor Manoliu on 11-Apr-18
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointment(Long appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        return optionalAppointment.orElse(null);
    }


    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentByPatient(Long patientId) {
        return appointmentRepository.findAppointmentsByPatient_Id(patientId);
    }

    @Override
    public List<Appointment> getAppointmentByDoctor(Long doctorId) {
        return appointmentRepository.findAppointmentsByDoctor_Id(doctorId);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }


}
