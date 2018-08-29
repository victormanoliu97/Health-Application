package com.example.health.appointmentreminderservice.job;

import com.example.health.appointmentreminderservice.boundry.transferobject.ReminderDTO;
import com.example.health.appointmentreminderservice.service.control.AppointmentService;
import com.example.health.appointmentreminderservice.service.control.PatientService;
import com.example.health.appointmentreminderservice.service.mail.MailSender;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReminderJob implements Job {

    private final MailSender mailSender;
    private final AppointmentService appointmentService;
    private final PatientService patientService;

    private ReminderDTO reminderDTO;

    @Autowired
    public ReminderJob(MailSender mailSender, AppointmentService appointmentService, PatientService patientService) {
        this.mailSender = mailSender;
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();

/*        String patientEmail = patientService.getAppointedPatientEmail(reminderDTO.getIdAppointment());
        Date startTime = appointmentService.getStartTimeOfAppointment(reminderDTO.getIdAppointment());*/

        String patientEmail = dataMap.getString("mail");
        String startTime = dataMap.getString("date");

        Format formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        String startTimeConverted = formatter.format(startTime);

        try {
            mailSender.sendEmail(patientEmail, startTimeConverted);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
