package com.gildedrose.domain.service;

import com.gildedrose.domain.factory.ItemProcessorFactory;
import com.gildedrose.domain.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GildedRose {

    private ItemProcessorFactory factory;

    @Autowired
    public GildedRose(ItemProcessorFactory factory) {
        this.factory = factory;
    }

    public List<Item> updateQuality(List<Item> items) {
        for (Item item : items) {
            factory.getProcessor(item).updateQuality(item);
        }
        return items;
    }
}