package com.example.health.patientappointmentmanagement.service;

import com.example.health.patientappointmentmanagement.boundry.transferobject.AppointmentDTO;
import com.example.health.patientappointmentmanagement.entity.repository.AppointmentRepository;
import com.example.health.patientappointmentmanagement.entity.repository.DoctorRepository;
import com.example.health.patientappointmentmanagement.entity.repository.DoctorSpecialityRepository;
import com.example.health.patientappointmentmanagement.entity.repository.SpecialityRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorSpecialityRepository doctorSpecialityRepository;
    private final SpecialityRepository specialityRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, DoctorSpecialityRepository doctorSpecialityRepository, SpecialityRepository specialityRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.doctorSpecialityRepository = doctorSpecialityRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public String makeAppointment(AppointmentDTO appointment) throws ParseException, JSONException {
        Integer specialityId = specialityRepository.getSpecialityNameById(appointment.getSpeciality());
        List<Integer> doctorIdList = doctorSpecialityRepository.getDoctorIdsPerSpecialityId(specialityId);
        Integer doctorId = doctorIdList.get(0);
        String startTime = appointment.getStartTime();
        String endTime = startTime;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date convertedStartDate = simpleDateFormat.parse(startTime);
        Date convertedEndDate = simpleDateFormat.parse(endTime);
        Date newEndDate = new Date(convertedEndDate.getTime() + 3600 * 1000);

        appointmentRepository.saveAppointment(
                appointment.getIdPatient(),
                doctorId,
                appointment.getCause(),
                specialityId,
                convertedStartDate,
                newEndDate
        );

        JSONObject responseJson = new JSONObject();

        responseJson.put("Type", "Success")
                    .put("Message", "Appointment was registered")
                    .put("status", 200);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(jsonObject);
    }
}
