package com.fiipractic.health.entity.repository;

import com.fiipractic.health.entity.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Victor Manoliu on 11-Apr-18
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAppointmentsByDoctor_Id(Long doctorId);
    List<Appointment> findAppointmentsByPatient_Id(Long patientId);
}
