package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;
import com.gildedrose.domain.service.ItemQualityConstraint;
import org.springframework.stereotype.Service;

@Service
public class ConjuredItemProcessor implements ItemProcessor {

    @Override
    public void updateQuality(Item item) {
        item.sellIn -= 1;

        item.quality = ItemQualityConstraint.ensureRange(item.quality - 2, 0, 50);
    }

    @Override
    public Type getType() {
        return Type.Conjured;
    }

}
