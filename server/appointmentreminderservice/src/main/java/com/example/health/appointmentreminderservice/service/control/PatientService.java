package com.example.health.appointmentreminderservice.service.control;

import org.springframework.stereotype.Service;

@Service
public interface PatientService {

    String getAppointedPatientEmail(Integer id);
}
