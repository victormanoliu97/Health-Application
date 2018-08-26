package com.example.health.registerpatientservice.entity.repository;

import com.example.health.registerpatientservice.entity.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PATIENTS(first_name, last_name, CNP, email, login_pin)" +
            "VALUES(:first_name, :last_name, :CNP, :email, :login_pin)", nativeQuery = true)
    void insertPatient(@Param("first_name")String firstName, @Param("last_name")String lastName,
                       @Param("CNP")String CNP, @Param("email")String email,
                       @Param("login_pin")Integer loginPin);


    @Query(value = "SELECT id_patient FROM patients WHERE CNP = :CNP AND email = :email", nativeQuery = true)
    Integer checkPatientExists(@Param("CNP")String CNP, @Param("email")String email);

}
