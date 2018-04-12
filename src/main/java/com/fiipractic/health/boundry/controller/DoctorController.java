package com.fiipractic.health.boundry.controller;

import com.fiipractic.health.boundry.dtos.DoctorDTO;
import com.fiipractic.health.boundry.dtos.PatientDTO;
import com.fiipractic.health.boundry.exceptions.BadRequestException;
import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.boundry.mapper.DoctorMapper;
import com.fiipractic.health.boundry.mapper.PatientMapper;
import com.fiipractic.health.control.service.DoctorService;
import com.fiipractic.health.control.service.PatientService;
import com.fiipractic.health.entity.model.Doctor;
import com.fiipractic.health.entity.model.Patient;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "doctors")
public class DoctorController {

    private DoctorService doctorService;
    private List<DoctorDTO> doctorDTOList;
    private List<Doctor> doctorList;

    @Autowired
    public DoctorController(DoctorService doctorService) {

        this.doctorService = doctorService;
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        List<Doctor> doctorList = new ArrayList<>();
    }

    @GetMapping
    public List<DoctorDTO> getDoctors() {

        doctorList = doctorService.getDoctors();

        for (Doctor doctor : doctorList) {
            doctorDTOList.add(DoctorMapper.MAPPER.fromDoctor(doctor));
        }
        return doctorDTOList;
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public DoctorDTO getDoctor(@PathVariable Long id) throws NotFoundException {

        if (doctorService.getDoctor(id) == null) {
            throw new NotFoundException(String.format("Doctor with id=%s was not found.", id));
        }
        return DoctorMapper.MAPPER.fromDoctor(doctorService.getDoctor(id));

    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public DoctorDTO saveDoctor(@RequestBody DoctorDTO doctorDTO) {

        return DoctorMapper.MAPPER.fromDoctor(doctorService.saveDoctor(DoctorMapper.MAPPER.toDoctor(doctorDTO)));
    }


    @PutMapping(value = "/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) throws NotFoundException, BadRequestException {
        if (doctorDTO.getDoctor_id().equals(id) == false) {
            throw new BadRequestException("This id and the id of the patient object are not the same");
        }
        if (doctorService.getDoctor(id) == null) {
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        DoctorMapper.MAPPER.toDoctor(doctorDTO, doctorService.getDoctor(id));
        return DoctorMapper.MAPPER.fromDoctor(doctorService.getDoctor(id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable("id") Long id) throws NotFoundException {
        if (doctorService.getDoctor(id) == null) {
            throw new NotFoundException(String.format("Patient with id=%s was not found.", id));
        }
        doctorService.deleteDoctor(doctorService.getDoctor(id));
    }

}
