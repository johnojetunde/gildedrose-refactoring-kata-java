package com.gildedrose.processor;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemQualityConstraint;

public class AgedBrieItemProcessor implements ItemProcessor {

    @Override
    public Item updateQuality(Item item) {
        item.sellIn -= 1;

        int incr = (item.sellIn < 0) ? 2 : 1;

        item.quality = ItemQualityConstraint.ensureRange(item.quality+incr,0, 50);

        return item;
    }
}
