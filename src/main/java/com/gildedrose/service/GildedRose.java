package com.gildedrose.service;

import com.gildedrose.factory.ItemProcessorFactory;
import com.gildedrose.model.Item;

public class GildedRose {
    private Item[] items;

    private ItemProcessorFactory factory;

    public GildedRose(Item[] items, ItemProcessorFactory factory) {
        this.items = items;
        this.factory = factory;
    }

    public void updateQuality() {
        for (Item item : items) {
            factory.getProcessor(item).updateQuality(item);
        }
    }
}