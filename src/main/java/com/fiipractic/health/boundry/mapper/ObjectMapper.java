package com.fiipractic.health.boundry.mapper;

import com.fiipractic.health.boundry.dtos.AppointmentDTO;
import com.fiipractic.health.entity.model.Appointment;
import com.fiipractic.health.entity.model.Doctor;
import com.fiipractic.health.entity.model.Patient;

public class ObjectMapper {

    public static void map2DoctorDb(Doctor doctorDb, Doctor doctorRequest) {
        doctorDb.setDoctorFirstName(doctorRequest.getDoctorFirstName());
        doctorDb.setDoctorLastName(doctorRequest.getDoctorLastName());
        doctorDb.setFunction(doctorRequest.getFunction());
        doctorDb.setAppointmentList(doctorRequest.getAppointmentList());
        doctorDb.setDoctorAdress(doctorRequest.getDoctorAdress());
        doctorDb.setDoctorEmail(doctorRequest.getDoctorEmail());
        doctorDb.setDoctorPhoneNumber(doctorRequest.getDoctorPhoneNumber());
    }

    public static void map2PatientDB(Patient patientDB, Patient patientRequest) {
        patientDB.setPatientFirstName(patientRequest.getPatientFirstName());
        patientDB.setPatientLastName(patientRequest.getPatientLastName());
        patientDB.setPatientAdress(patientRequest.getPatientAdress());
        patientDB.setPatientAge(patientRequest.getPatientAge());
        patientDB.setPatientAdress(patientRequest.getPatientAdress());
        patientDB.setPatientEmail(patientRequest.getPatientEmail());
        patientDB.setPatientPhoneNumber(patientRequest.getPatientPhoneNumber());
        patientDB.setAppointmentList(patientRequest.getAppointmentList());
    }

    public static Appointment toObject(AppointmentDTO appointmentDto, Patient patient, Doctor doctor) {
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStartDate(appointmentDto.getStartDate());
        appointment.setEndDate(appointmentDto.getEndDate());
        appointment.setAppointmentAdress(appointmentDto.getAppointmentAdress());
        appointment.setCause(appointmentDto.getCause());
        appointment.setGravity(appointmentDto.getGravity());
        return appointment;
    }
}
