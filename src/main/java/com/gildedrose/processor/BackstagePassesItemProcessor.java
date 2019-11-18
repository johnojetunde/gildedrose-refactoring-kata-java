package com.gildedrose.processor;

import com.gildedrose.Item;
import com.gildedrose.ItemQualityConstraint;

public class BackstagePassesItemProcessor implements ItemProcessor {

    @Override
    public Item updateQuality(Item item) {
        item.sellIn -= 1;

        int incr = 1;
        if (item.sellIn <= 10 && item.sellIn > 5) {
            incr = 2;
        } else if (item.sellIn <= 5 && item.sellIn > 0) {
            incr = 3;
        } else if (item.sellIn < 0) {
            incr = -item.quality;
        }

        item.quality = ItemQualityConstraint.ensureRange(item.quality + incr, 0, 50);

        return item;
    }
}
