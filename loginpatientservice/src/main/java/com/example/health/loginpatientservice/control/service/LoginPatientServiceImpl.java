package com.example.health.loginpatientservice.control.service;

import com.example.health.loginpatientservice.boundry.exceptions.PatientNotExistException;
import com.example.health.loginpatientservice.boundry.transferobject.PatientDTO;
import com.example.health.loginpatientservice.entity.repository.PatientRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginPatientServiceImpl implements LoginPatientService {

    private final PatientRepository patientRepository;
    private final Logger logger = Logger.getLogger(LoginPatientServiceImpl.class);

    @Autowired
    public LoginPatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public String loginPatient(PatientDTO patient) throws JSONException {
        JSONObject responseJson = new JSONObject();
        Integer patientId = patientRepository.checkLoginPinExists(patient.getLoginPin());

        if(patientId == null) {
            responseJson.put("Type", "Fail")
                    .put("Message", "Patient does not exist in the database")
                    .put("status", 400);
            logger.info(new PatientNotExistException("Patient does not exist in the database"));
        }
        else {
            String patientFirstName = patientRepository.getUserFirstName(patientId);
            String patientLastName = patientRepository.getUserLastName(patientId);
            String patientEmail = patientRepository.getUserEmail(patientId);
            String patientCNP = patientRepository.getUserCNP(patientId);

            responseJson.put("Type", "Success")
                        .put("Message", "Patient logged in with success")
                        .put("status", 200)
                        .put("firstName", patientFirstName)
                        .put("lastName", patientLastName)
                        .put("email", patientEmail)
                        .put("cnp", patientCNP);
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(jsonObject);
    }
}
