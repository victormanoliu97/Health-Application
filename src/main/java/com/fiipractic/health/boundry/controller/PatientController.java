package com.fiipractic.health.boundry.controller;

import com.fiipractic.health.boundry.exceptions.BadRequestException;
import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.boundry.mapper.ObjectMapper;
import com.fiipractic.health.control.service.PatientService;
import com.fiipractic.health.entity.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {

        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/filter")
    public List<Patient> getPatientsByAge(@RequestParam("patientAge") Long patientAge) {
        return patientService.findAllPatientsWithAge(patientAge);
    }

    @GetMapping(value = "/{id}")
    public Patient getPatient(@PathVariable("id") Long id) throws NotFoundException {
        Patient patient = patientService.getPatient(id);
        if (patient == null) {
            throw new NotFoundException(String.format("Doctor with id=%s was not found.", id));
        }
        return patient;
    }

    @PutMapping(value = "/{id}")
    public Patient updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) throws BadRequestException, NotFoundException {
        //validate request
        if (!id.equals(patient.getId())) {
            throw new BadRequestException("The id is not the same with id from object");
        }
        Patient patientDB = patientService.getPatient(id);
        if (patientDB == null) {
            throw new NotFoundException(String.format("Doctor with id=%s was not found.", id));
        }
        ObjectMapper.map2PatientDB(patientDB, patient);
        return patientService.updatePatient(patientDB);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable("id") Long id) throws NotFoundException {
        if (patientService.getPatient(id) == null) {
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        patientService.deletePatient(patientService.getPatient(id));
    }

}
