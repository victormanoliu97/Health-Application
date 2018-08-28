package com.example.health.patientappointmentmanagement.service;

import com.example.health.patientappointmentmanagement.entity.pojo.SpecialityPOJO;
import com.example.health.patientappointmentmanagement.entity.repository.SpecialityRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public String getAllSpecialities() throws JSONException {
        List<String> nameSpecialityList = specialityRepository.getAllSpecialitiesNames();

        JSONObject responseJson = new JSONObject();

        responseJson.put("specialities", nameSpecialityList);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(jsonObject);
    }
}
