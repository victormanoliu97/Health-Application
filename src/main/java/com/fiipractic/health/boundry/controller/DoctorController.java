package com.fiipractic.health.boundry.controller;

import com.fiipractic.health.boundry.dtos.DoctorDTO;
import com.fiipractic.health.boundry.exceptions.BadRequestException;
import com.fiipractic.health.boundry.exceptions.NotFoundException;
import com.fiipractic.health.boundry.mapper.ObjectMapper;
import com.fiipractic.health.control.service.DoctorService;
import com.fiipractic.health.entity.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "doctors")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping(value = "/{id}")
    public Doctor getDoctor(@PathVariable("id") Long id) throws NotFoundException {
        Doctor doctor = doctorService.getDoctor(id);
        if (doctor == null) {
            throw new NotFoundException(String.format("Doctor with id=%s was not found.", id));
        }
        return doctor;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        Doctor doctor1 = doctorService.saveDoctor(doctor);
        return doctor1;
    }

    @PutMapping(value = "/{id}")
    public Doctor updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) throws BadRequestException, NotFoundException {
        //validate request
        if (!id.equals(doctor.getId())) {
            throw new BadRequestException("The id is not the same with id from object");
        }
        Doctor doctorDb = doctorService.getDoctor(id);
        if (doctorDb == null) {
            throw new NotFoundException(String.format("Doctor with id=%s was not found.", id));
        }
        ObjectMapper.map2DoctorDb(doctorDb, doctor);
        return doctorService.updateDoctor(doctorDb);
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
