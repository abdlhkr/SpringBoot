package com.example.exception_handling.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class schedulingExample {

    @Scheduled(cron = "*/5 * * * * *")
    public void countToTen(){
        for (int i = 0; i < 10; i++){

            System.out.println(i);
        }
    }
}
