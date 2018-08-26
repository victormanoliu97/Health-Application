package com.example.health.loginpatientservice.entity.repository;

import com.example.health.loginpatientservice.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "SELECT id_patient FROM PATIENTS WHERE login_pin = :login_pin", nativeQuery = true)
    Integer checkLoginPinExists(@Param("login_pin") Integer loginPin);

    @Query(value = "SELECT first_name FROM PATIENTS WHERE id_patient = :id_patient", nativeQuery = true)
    String getUserFirstName(@Param("id_patient") Integer idPatient);

    @Query(value = "SELECT last_name FROM PATIENTS WHERE id_patient = :id_patient", nativeQuery = true)
    String getUserLastName(@Param("id_patient") Integer idPatient);

    @Query(value = "SELECT CNP FROM PATIENTS WHERE id_patient = :id_patient", nativeQuery = true)
    String getUserCNP(@Param("id_patient") Integer idPatient);

    @Query(value = "SELECT email FROM PATIENTS WHERE id_patient = :id_patient", nativeQuery = true)
    String getUserEmail(@Param("id_patient") Integer idPatient);
}
