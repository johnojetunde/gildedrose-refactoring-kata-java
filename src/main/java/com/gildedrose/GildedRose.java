package com.gildedrose;

import com.gildedrose.processor.*;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }


    void updateQuality() {
        for (Item item : items) {
            getProcessor(item).updateQuality(item);
        }
    }

    private ItemProcessor getProcessor(Item item) {
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