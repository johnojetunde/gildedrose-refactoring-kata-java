package com.gildedrose.processor;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemQualityConstraint;
import org.springframework.stereotype.Service;

@Service
public class AgedBrieItemProcessor implements ItemProcessor {

    @Override
    public Item updateQuality(Item item) {
        item.sellIn -= 1;

        int incr = 1;

        item.quality = ItemQualityConstraint.ensureRange(item.quality + incr, 0, 50);

        return item;
    }

    @Override
    public Type getType() {
        return Type.Aged_Brie;
    }
}
