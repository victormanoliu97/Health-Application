package com.example.health.appointmentreminderservice.boundry.controller;

import com.example.health.appointmentreminderservice.boundry.transferobject.ReminderDTO;
import com.example.health.appointmentreminderservice.scheduler.ReminderScheduler;
import org.quartz.SchedulerException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class AppointmentReminderController {

    private ReminderScheduler reminderScheduler;

    @PostMapping(value = "set-reminder")
    public void setReminder(@RequestBody ReminderDTO reminder) throws SchedulerException {
        reminderScheduler.fire(reminder);
    }

}
