package com.fiipractic.health.mapper;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Pacient;

public class ObjectMapper {

    public static void map2DoctorDb(Doctor doctorDb, Doctor doctorRequest){
        doctorDb.setName(doctorRequest.getName());
        doctorDb.setFunction(doctorRequest.getFunction());
    }

    public static void map2PacientDb(Pacient pacientDb, Pacient pacientRequest){
        pacientDb.setPacientFirstName(pacientRequest.getPacientFirstName());
        pacientDb.setPacientLastName(pacientRequest.getPacientLastName());
        pacientDb.setPacientDisease(pacientRequest.getPacientDisease());
        pacientDb.setPacientSex(pacientRequest.getPacientSex());
        pacientDb.setPacientHeight(pacientRequest.getPacientHeight());
        pacientDb.setPacientWeight(pacientRequest.getPacientWeight());
        pacientDb.setPacientState(pacientRequest.getPacientState());
        pacientDb.setDateArrived(pacientRequest.getDateArrived());
    }
}
