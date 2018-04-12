package com.fiipractic.health.boundry.controller;

import com.fiipractic.health.boundry.dtos.PatientDTO;
import com.fiipractic.health.boundry.exceptions.BadRequestException;
import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.boundry.mapper.PatientMapper;
import com.fiipractic.health.control.service.PatientService;
import com.fiipractic.health.entity.model.Patient;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "patients")
public class PatientController {

    private PatientService patientService;
    private List<PatientDTO> patientDTOList;
    private List<Patient> patientList;

    @Autowired
    public PatientController(PatientService patientService) {

        this.patientService = patientService;
        List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patientList = new ArrayList<>();
    }

    @GetMapping
    public List<PatientDTO> getPatients() {

        patientList = patientService.getPatients();

        for (Patient patient : patientList) {
            patientDTOList.add(PatientMapper.MAPPER.fromPatient(patient));
        }
        return patientDTOList;
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public PatientDTO getPacient(@PathVariable Long id) throws NotFoundException {

        if (patientService.getPatient(id) == null) {
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        return PatientMapper.MAPPER.fromPatient(patientService.getPatient(id));

    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PatientDTO savePatient(@RequestBody PatientDTO patient) {

        return PatientMapper.MAPPER.fromPatient(patientService.savePatient(PatientMapper.MAPPER.toPatient(patient)));
    }

    @GetMapping("/filter")
    public List<Patient> getPatientsByAge(@RequestParam("patientAge") Long patientAge) {
        return patientService.findAllPatientsWithAge(patientAge);
    }

    @PutMapping(value = "/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) throws NotFoundException, BadRequestException {
        if (patientDTO.getPatient_id().equals(id) == false) {
            throw new BadRequestException("This id and the id of the patient object are not the same");
        }
        if (patientService.getPatient(id) == null) {
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        PatientMapper.MAPPER.toPatient(patientDTO, patientService.getPatient(id));
        return PatientMapper.MAPPER.fromPatient(patientService.getPatient(id));
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
