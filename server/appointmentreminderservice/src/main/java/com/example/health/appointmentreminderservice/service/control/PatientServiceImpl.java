package com.example.health.appointmentreminderservice.service.control;

import com.example.health.appointmentreminderservice.entity.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public String getAppointedPatientEmail(Integer id) {
        return patientRepository.getUserEmailByIdPatient(id);
    }
}
