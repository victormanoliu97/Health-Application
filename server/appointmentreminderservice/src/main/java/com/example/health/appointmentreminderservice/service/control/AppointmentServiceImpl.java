package com.example.health.appointmentreminderservice.service.control;

import com.example.health.appointmentreminderservice.entity.repository.AppointmentRepository;
import com.example.health.appointmentreminderservice.service.control.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Date getStartTimeOfAppointment(Integer id) {
        return appointmentRepository.selectStartTimeById(id);
    }
}
