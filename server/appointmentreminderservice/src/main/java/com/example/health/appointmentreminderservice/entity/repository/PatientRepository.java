package com.example.health.appointmentreminderservice.entity.repository;

import com.example.health.appointmentreminderservice.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "SELECT email FROM PATIENTS WHERE id_patient = :id_patient", nativeQuery = true)
    String getUserEmailByIdPatient(@Param("id_patient") Integer idPatient);
}
