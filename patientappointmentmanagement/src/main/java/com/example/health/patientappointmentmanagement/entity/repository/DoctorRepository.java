package com.example.health.patientappointmentmanagement.entity.repository;

import com.example.health.patientappointmentmanagement.entity.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "SELECT first_name FROM DOCTORS WHERE id_doctor = :id_doctor", nativeQuery = true)
    String getDoctorFirstNameById(@Param("id_doctor")Integer idDoctor);

    @Query(value = "SELECT last_name FROM DOCTORS WHERE id_doctor = :id_doctor", nativeQuery = true)
    String getDoctorLastNameById(@Param("id_doctor")Integer idDoctor);

    @Query(value = "SELECT function FROM DOCTORS WHERE id_doctor = :id_doctor", nativeQuery = true)
    String getDoctorFunctionById(Integer idDoctor);
}
