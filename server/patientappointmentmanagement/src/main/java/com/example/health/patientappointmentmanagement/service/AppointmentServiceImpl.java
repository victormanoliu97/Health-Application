package com.example.health.patientappointmentmanagement.service;

import com.example.health.patientappointmentmanagement.boundry.transferobject.AppointmentDTO;
import com.example.health.patientappointmentmanagement.entity.pojo.AppointmentPOJO;
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
import java.util.ArrayList;
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

    @Override
    public String getPatientAppointments(Integer patientId) throws JSONException {
        List<Integer> doctorIdsList = appointmentRepository.getDoctorIdOfAppointments(patientId);
        List<String> causeList = appointmentRepository.getCausesOfAppointments(patientId);
        List<Integer> specialityIdsList = appointmentRepository.getSpecialityIdOfAppointments(patientId);
        List<Date> startTimesList =  appointmentRepository.getStartTimeOfAppointments(patientId);
        List<Date> endTimeList = appointmentRepository.getEndTimeOfAppointments(patientId);
        List<Integer> appointmentsIdsList = appointmentRepository.getIdsOfAppointments(patientId);
        List<AppointmentPOJO> appointmentPOJOList = new ArrayList<>();

        List<AppointmentPOJO> appointmentPOJOListDistinct = new ArrayList<>();

        for(Integer id : doctorIdsList) {
            for(String cause : causeList) {
                for(Date date1 : startTimesList) {
                    for(Date date2 : endTimeList) {
                        for(Integer id2 : specialityIdsList) {
                                for(Integer id3 : appointmentsIdsList) {
                                    String currentDoctorFirstName = doctorRepository.getDoctorFirstNameById(id);
                                    String currentDoctorLastName = doctorRepository.getDoctorLastNameById(id);
                                    String currentDoctorEmail = doctorRepository.getDoctorEmailById(id);
                                    String currentCause = cause;
                                    Date currentStartTime = date1;
                                    Date currentEndTime = date2;
                                    String currentSpecialityName = specialityRepository.getSpecialityIdByName(id2);

                                    appointmentPOJOList.add(new AppointmentPOJO(currentDoctorFirstName, currentDoctorLastName,
                                            currentDoctorEmail, currentCause, currentSpecialityName, currentStartTime, currentEndTime,
                                            id3));
                                }
                        }
                    }
                }
            }
        }

        for(AppointmentPOJO i : appointmentPOJOList) {
            boolean isFound = false;
            for(AppointmentPOJO j : appointmentPOJOListDistinct) {
                if(j.getAppointmentId().equals(i.getAppointmentId()) || (j.equals(i))
                        || j.getStarTime().equals(i.getStarTime()) || j.getEndTime().equals(i.getStarTime())
                        || j.getEndTime().equals(i.getEndTime())
                        || j.getAppointmentCause().equals(i.getAppointmentCause())
                        || j.getDoctorFirstName().equals(i.getDoctorFirstName())
                        || j.getDoctorEmail().equals(i.getDoctorEmail())
                        || j.getSpecialityName().equals(i.getSpecialityName())) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound) appointmentPOJOListDistinct.add(i);
        }


        Gson gsonBuilder = new GsonBuilder().create();

        return gsonBuilder.toJson(appointmentPOJOListDistinct);
    }

    @Override
    public String deleteAppointment(Integer id) throws JSONException {
        JSONObject responseJson = new JSONObject();
        int responseCode;

        if(appointmentRepository.checkAppointmentExistsById(id) == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "Appointment with that id does not exist in the database")
                    .put("status", 400);
            responseCode = 400;
        }
        else {
            responseJson.put("Type", "Success")
                    .put("Message", "Appointment deleted with success")
                    .put("status", 200);
            responseCode = 200;
        }

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String prettyResponse = gson.toJson(jsonObject);

        if(responseCode == 200) {
            appointmentRepository.deleteAppointmentById(id);
        }
        return prettyResponse;
    }


}
