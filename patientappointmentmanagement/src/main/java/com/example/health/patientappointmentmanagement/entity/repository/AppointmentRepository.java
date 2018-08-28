package com.example.health.patientappointmentmanagement.entity.repository;

import com.example.health.patientappointmentmanagement.entity.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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



    @Query(value = "SELECT id_doctor FROM APPOINTMENTS WHERE id_patient = :id_patient AND CURDATE() < start_time", nativeQuery = true)
    List<Integer> getDoctorIdOfAppointments(@Param("id_patient")Integer idPatient);

    @Query(value = "SELECT cause FROM APPOINTMENTS WHERE id_patient = :id_patient AND CURDATE() < start_time", nativeQuery = true)
    List<String> getCausesOfAppointments(@Param("id_patient")Integer idPatient);

    @Query(value = "SELECT id_speciality FROM APPOINTMENTS WHERE id_patient = :id_patient AND CURDATE() < start_time", nativeQuery = true)
    List<Integer> getSpecialityIdOfAppointments(@Param("id_patient")Integer idPatient);

    @Query(value = "SELECT start_time FROM APPOINTMENTS WHERE id_patient = :id_patient AND CURDATE() < start_time", nativeQuery = true)
    List<Date> getStartTimeOfAppointments(@Param("id_patient")Integer idPatient);

    @Query(value = "SELECT end_time FROM APPOINTMENTS WHERE id_patient = :id_patient AND CURDATE() < start_time", nativeQuery = true)
    List<Date> getEndTimeOfAppointments(@Param("id_patient")Integer idPatient);

    @Query(value = "SELECT id FROM APPOINTMENTS WHERE id_patient = :id_patient", nativeQuery = true)
    List<Integer> getIdsOfAppointments(@Param("id_patient")Integer idPatient);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM APPOINTMENTS WHERE id = :id", nativeQuery = true)
    void deleteAppointmentById(@Param("id")Integer id);

    @Query(value = "SELECT id FROM APPOINTMENTS WHERE id = :id", nativeQuery = true)
    Integer checkAppointmentExistsById(@Param("id") Integer id);
}
