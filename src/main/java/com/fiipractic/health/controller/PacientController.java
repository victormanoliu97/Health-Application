package com.fiipractic.health.controller;

import com.fiipractic.health.exceptions.BadRequestException;
import com.fiipractic.health.exceptions.NotFoundException;
import com.fiipractic.health.mapper.ObjectMapper;
import com.fiipractic.health.model.Pacient;
import com.fiipractic.health.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Victor Manoliu on 21-Mar-18
 */

@RestController
@RequestMapping(value = "pacients")
public class PacientController {

    private PacientService pacientService;

    @Autowired
    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Pacient getPacient(@PathVariable int id) throws NotFoundException {

        if (pacientService.getPacient(id) == null) {
            throw new NotFoundException(String.format("Pacient with id=%s was not found.", id));
        }
        return pacientService.getPacient(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Pacient savePacient(@RequestBody Pacient pacient) {
        return pacientService.savePacient(pacient);
    }

    @PutMapping(value = "/{id}")
    public Pacient updatePacient(@PathVariable("id") int id, @RequestBody Pacient pacient) throws BadRequestException, NotFoundException {
        //validate request
        if (id == pacient.getPacientId()) {
            throw new BadRequestException("The id is not the same with id from object");
        }
        Pacient pacientDb = pacientService.getPacient(id);
        if (pacientDb == null) {
            throw new NotFoundException(String.format("Pacient with id=%s was not found.", id));
        }
        ObjectMapper.map2PacientDb(pacientDb, pacient);

        return pacientService.updatePacient(pacientDb);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePacient(@PathVariable int id) throws NotFoundException {
        Pacient pacientDb = pacientService.getPacient(id);
        if (pacientDb == null) {
            throw new NotFoundException(String.format("Pacient with id=%s was not found.", id));
        }
        pacientService.deletePacient(pacientDb);
    }
}
