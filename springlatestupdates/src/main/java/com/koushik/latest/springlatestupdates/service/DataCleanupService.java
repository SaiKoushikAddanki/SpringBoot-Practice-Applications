package com.koushik.latest.springlatestupdates.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class DataCleanupService {

    @Scheduled(cron = "${cron.for.db.clean}")
    @SchedulerLock(name = "DBdatacleanupScheduler")
    public void executeDataFromDBCleanup() {
        System.out.println("Scheduled job is triggered and will perform DB clean up");
    }
}
