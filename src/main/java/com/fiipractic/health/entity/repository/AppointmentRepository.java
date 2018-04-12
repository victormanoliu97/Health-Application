package com.fiipractic.health.entity.repository;

import com.fiipractic.health.entity.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Victor Manoliu on 11-Apr-18
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
