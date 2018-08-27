package com.example.health.patientappointmentmanagement.entity.repository;

import com.example.health.patientappointmentmanagement.entity.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO APPOINTMENTS(id_patient, id_doctor, cause, id_speciality, start_time, end_time) VALUES" +
            "(:id_patient, :id_doctor, :cause, :id_speciality, :start_time, :end_time)", nativeQuery = true)
    void saveAppointment(@Param("id_patient")Integer idPatient, @Param("id_doctor")Integer idDoctor,
                         @Param("cause")String cause,
                         @Param("id_speciality")Integer idSpeciality,
                         @Param("start_time")Date startTime, @Param("end_time")Date endTime);
}
