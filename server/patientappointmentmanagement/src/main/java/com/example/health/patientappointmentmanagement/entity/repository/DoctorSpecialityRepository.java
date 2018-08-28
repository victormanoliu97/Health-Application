package com.example.health.patientappointmentmanagement.entity.repository;

import com.example.health.patientappointmentmanagement.entity.model.DoctorSpecialities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpecialities, Integer> {

    @Query(value = "SELECT id_doctor FROM DOCTOR_SPECIALITIES WHERE id_speciality = :id_speciality", nativeQuery = true)
    List<Integer> getDoctorIdsPerSpecialityId(@Param("id_speciality")Integer idSpeciality);

}
