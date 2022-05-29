package com.example.redis.crud.schedules;

import java.util.logging.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class ScheduleFixedDelayTask {
    @Scheduled(cron = "* * * * * *")
    public void scheduleFixedDelayTask(){
        Logger.getGlobal().info("Fixed delay task:" + System.currentTimeMillis() / 1000);
    }
}
