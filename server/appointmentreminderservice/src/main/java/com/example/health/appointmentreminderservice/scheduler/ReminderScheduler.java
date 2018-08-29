package com.example.health.appointmentreminderservice.scheduler;

import com.example.health.appointmentreminderservice.boundry.transferobject.ReminderDTO;
import com.example.health.appointmentreminderservice.config.AutoWiringSpringBeanJobFactory;
import com.example.health.appointmentreminderservice.job.ReminderJob;
import com.example.health.appointmentreminderservice.service.control.AppointmentService;
import com.example.health.appointmentreminderservice.service.control.PatientService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Configuration
@ConditionalOnExpression("'${using.spring.schedulerFactory}'=='true'")
public class ReminderScheduler {

    private final ApplicationContext applicationContext;
    private final AppointmentService appointmentService;
    private final PatientService patientService;

    @Autowired
    public ReminderScheduler(ApplicationContext applicationContext, AppointmentService appointmentService, PatientService patientService) {
        this.applicationContext = applicationContext;
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

/*    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();

        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    public SchedulerFactoryBean scheduler(Trigger trigger, JobDetail simpleJob) throws IOException, SchedulerException {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));

        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
        schedulerFactoryBean.setJobDetails(simpleJob);
        schedulerFactoryBean.setTriggers(trigger);

        return schedulerFactoryBean;
    }

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(ReminderJob.class);
        jobDetailFactory.setName("Qrtz_Job_Detail");
        jobDetailFactory.setDescription("Invoke Sample Job service...");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    @Bean
    public SimpleTriggerFactoryBean trigger(JobDetail job) {
*//*        Date startTime = appointmentService.getStartTimeOfAppointment(reminderDTO.getIdAppointment());
        Integer hoursBeforeToSendReminder = reminderDTO.getHoursBefore();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.HOUR, -hoursBeforeToSendReminder);
        Date reminderTime = calendar.getTime();

        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group")
                .startAt(reminderTime)
                .endAt(reminderTime)
                .forJob(job)
                .build();

        return (SimpleTriggerFactoryBean) trigger;*//*
        return null;
    }*/

    public void fire(ReminderDTO reminder) throws SchedulerException {
        SchedulerFactory schedFact = new StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();

        String email = patientService.getAppointedPatientEmail(reminder.getIdAppointment());
        Date auxDate = appointmentService.getStartTimeOfAppointment(reminder.getIdAppointment());

        Format formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        String startTimeConverted = formatter.format(auxDate);

        JobDetail job = JobBuilder.newJob(ReminderJob.class)
                .withIdentity("myJob", "group")
                .usingJobData("mail", email)
                .usingJobData("date", startTimeConverted)
                .build();

        Date startTime = appointmentService.getStartTimeOfAppointment(reminder.getIdAppointment());
        Integer hoursBeforeToSendReminder = reminder.getHoursBefore();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.HOUR, -hoursBeforeToSendReminder);
        Date reminderTime = calendar.getTime();

        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group")
                .startAt(reminderTime)
                .endAt(reminderTime)
                .forJob(job)
                .build();


        sched.scheduleJob(job, trigger);
    }

}
