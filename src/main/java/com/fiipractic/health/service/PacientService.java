package com.fiipractic.health.service;

import com.fiipractic.health.model.Pacient;

import java.util.List;

/**
 * @author Victor Manoliu on 21-Mar-18
 */
public interface PacientService {

    List<Pacient> getPacients();

    Pacient getPacient(int id);

    Pacient savePacient(Pacient pacient);

    Pacient updatePacient(Pacient pacient);

    void deletePacient(Pacient pacient);
}
