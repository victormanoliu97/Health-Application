package com.example.health.appointmentreminderservice.service.control;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface AppointmentService {

    Date getStartTimeOfAppointment(Integer id);
}
