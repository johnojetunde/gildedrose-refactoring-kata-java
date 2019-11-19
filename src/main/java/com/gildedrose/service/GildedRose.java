package com.gildedrose.service;

import com.gildedrose.factory.ItemProcessorFactory;
import com.gildedrose.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GildedRose {

    private ItemProcessorFactory factory;

    @Autowired
    public GildedRose(ItemProcessorFactory factory) {
        this.factory = factory;
    }

    public void updateQuality(Item[] items) {
        for (Item item : items) {
            factory.getProcessor(item).updateQuality(item);
        }
    }
}