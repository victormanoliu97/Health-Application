package com.fiipractic.health.service;

import com.fiipractic.health.db.HealthDB;
import com.fiipractic.health.model.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Victor Manoliu on 21-Mar-18
 */
@Service
public class PacientServiceImpl implements PacientService {

    private HealthDB healthDB;

    @Autowired
    public PacientServiceImpl(HealthDB healthDB) {
        this.healthDB = healthDB;
    }


    @Override
    public List<Pacient> getPacients() {
        return healthDB.getPacients();
    }

    @Override
    public Pacient getPacient(int id) {
        return healthDB.getPacient(id);
    }


    @Override
    public Pacient savePacient(Pacient pacient) {
        return healthDB.savePacient(pacient);
    }

    @Override
    public Pacient updatePacient(Pacient pacient) {
        return healthDB.updatePacient(pacient);
    }

    @Override
    public void deletePacient(Pacient pacient) {
        healthDB.deletePacient(pacient);
    }
}
