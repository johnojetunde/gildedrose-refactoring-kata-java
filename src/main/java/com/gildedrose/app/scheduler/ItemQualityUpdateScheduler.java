package com.gildedrose.app.scheduler;

import com.gildedrose.app.job.ItemQualityUpdateJob;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ItemQualityUpdateScheduler {

    private final ItemQualityUpdateJob qualityUpdateJob;

    public ItemQualityUpdateScheduler(ItemQualityUpdateJob qualityUpdateJob) {
        this.qualityUpdateJob = qualityUpdateJob;
    }

    @Scheduled(cron = "${item.quality.update.cron:0 0 21 * * ?}")
    public void scheduleTaskUsingCronExpression() {
        qualityUpdateJob.run();
    }

}
