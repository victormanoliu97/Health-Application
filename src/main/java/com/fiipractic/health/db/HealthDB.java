package com.fiipractic.health.db;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Pacient;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HealthDB {

    private Map<Integer, Doctor> doctors;
    private Map<Integer, Pacient> pacientMap;

    public HealthDB() {
        this.doctors = new HashMap<>();
        this.pacientMap = new HashMap<>();

    }

    public List<Doctor> getDoctors() {
        return new ArrayList<Doctor>(doctors.values());
    }

    public Doctor getDoctor(int id) {
        return doctors.get(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        //generate an id
        doctor.setId(145);
        this.doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public Doctor updateDoctor(Doctor doctor) {
        this.doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public void deleteDoctor(Doctor doctor) {
        this.doctors.remove(doctor.getId());
    }


    public List<Pacient> getPacients() {
        return new ArrayList<Pacient>(pacientMap.values());
    }

    public Pacient getPacient(int id) {
        return pacientMap.get(id);
    }

    public Pacient savePacient(Pacient pacient) {
        pacient.setPacientId(905);
        this.pacientMap.put(pacient.getPacientId(), pacient);
        return pacient;
    }

    public Pacient updatePacient(Pacient pacient) {
        this.pacientMap.put(pacient.getPacientId(), pacient);
        return pacient;
    }

    public void deletePacient(Pacient pacient) {
        this.doctors.remove(pacient.getPacientId());
    }
}
