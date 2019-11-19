package com.gildedrose.factory;

import com.gildedrose.model.Item;
import com.gildedrose.processor.*;

public class ItemProcessorFactory {

    public ItemProcessor getProcessor(Item item) {
        if (item.name.contains("Backstage passes")) {
            return new BackstagePassesItemProcessor();
        } else if (item.name.contains("Aged Brie")) {
            return new AgedBrieItemProcessor();
        } else if (item.name.contains("Sulfuras")) {
            return new SulfurasItemProcessor();
        } else if (item.name.contains("Conjured")) {
            return new ConjuredItemProcessor();
        }
        return new DefaultItemProcessor();
    }
}
