package com.gildedrose.processor;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemQualityConstraint;
import org.springframework.stereotype.Service;

@Service
public class DefaultItemProcessor implements ItemProcessor {

    @Override
    public Item updateQuality(Item item) {
        item.sellIn -= 1;

        int decrement = (item.sellIn >= 0) ? 1 : 2;

        item.quality = ItemQualityConstraint.ensureRange(item.quality - decrement, 0, 50);

        return item;
    }

    @Override
    public Type getType() {
        return Type.Default;
    }
}
