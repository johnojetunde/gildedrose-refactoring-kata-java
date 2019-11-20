package com.gildedrose.app.job;

import com.gildedrose.domain.exception.ItemServiceException;
import com.gildedrose.domain.service.ItemQualityUpdate;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Log
@Service
public class ItemQualityUpdateJob implements Runnable {

    private final ItemQualityUpdate qualityUpdate;

    @Autowired
    public ItemQualityUpdateJob(ItemQualityUpdate qualityUpdate) {
        this.qualityUpdate = qualityUpdate;
    }


    @Override
    public void run() {
        log.info("------------------ Item Quality Update Job started -----------------");
        try {

            qualityUpdate.update();

            log.info("------------------ Item Quality Update Job completed successfully -----------------");
        } catch (ItemServiceException e) {
            log.log(Level.SEVERE, "Item Quality Update Job Failed -- Cause:", e);
        }

    }
}
