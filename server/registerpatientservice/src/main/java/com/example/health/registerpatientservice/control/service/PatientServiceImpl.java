package com.example.health.registerpatientservice.control.service;

import com.example.health.registerpatientservice.boundry.transferobject.PatientDTO;
import com.example.health.registerpatientservice.entity.repository.PatientRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final JavaMailSender javaMailSender;

    private Integer generatedPin = generateLoginPin();

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, JavaMailSender javaMailSender) {
        this.patientRepository = patientRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String savePatient(PatientDTO patient) throws JSONException, MessagingException {
        JSONObject responseJson = new JSONObject();
        int responseCode;

        if(patientAlreadyExists(patient)) {
            responseJson.put("Type", "Fail")
                    .put("Message", "Patient already exists")
                    .put("status", 400);
            responseCode = 400;
        }
        else {
            responseJson.put("Type", "Success")
                    .put("Message", "Patient registered with success")
                    .put("status", 200);
            responseCode = 200;
        }

        if(responseCode == 200) {
            patientRepository.insertPatient(patient.getFirstName(),
                    patient.getLastName(),
                    patient.getPatientCNP(),
                    patient.getEmail(),
                    generatedPin);
            sendEmail(patient);
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(String.valueOf(responseJson)).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(jsonObject);
    }

    @Override
    public Integer generateLoginPin() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    @Override
    public boolean patientAlreadyExists(PatientDTO patient) {
        return patientRepository.checkPatientExists(patient.getPatientCNP(), patient.getEmail()) != null;
    }

    @Override
    public void sendEmail(PatientDTO patient) throws MessagingException {
        Integer generatedLoginPIN = generatedPin;

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(patient.getEmail());
        mimeMessageHelper.setSubject("Account created");
        mimeMessageHelper.setText(String.format("Hello %s. Thank you for choosing out health services , " +
                "your new account is created", patient.getLastName())
                + String.format(" Your login PIN is: %s", generatedLoginPIN));

        javaMailSender.send(mimeMessage);
    }

}
