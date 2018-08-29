package com.example.health.appointmentreminderservice.entity.repository;

import com.example.health.appointmentreminderservice.entity.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "SELECT start_time FROM APPOINTMENTS WHERE id = :id", nativeQuery = true)
    Date selectStartTimeById(@Param("id") Integer id);

    @Query(value = "SELECT id_patient FROM APPOINTMENTS WHERE id = :id", nativeQuery = true)
    Integer getIdPatientByIdAppointment(@Param("id") Integer id);
}
