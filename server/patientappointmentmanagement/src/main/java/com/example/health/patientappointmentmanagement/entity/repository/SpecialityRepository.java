package com.example.health.patientappointmentmanagement.entity.repository;

import com.example.health.patientappointmentmanagement.entity.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

    @Query(value = "SELECT name FROM SPECIALITIES", nativeQuery = true)
    List<String> getAllSpecialitiesNames();

    @Query(value = "SELECT id_speciality FROM SPECIALITIES", nativeQuery = true)
    List<Integer> getAllSpecialitiesIds();

    @Query(value = "SELECT id_speciality FROM SPECIALITIES WHERE name = :name", nativeQuery = true)
    Integer getSpecialityNameById(@Param("name")String name);

    @Query(value = "SELECT name FROM SPECIALITIES WHERE id_speciality = :id_speciality", nativeQuery = true)
    String getSpecialityIdByName(@Param("id_speciality")Integer idSpeciality);

}
