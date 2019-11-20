package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;

public interface ItemProcessor {
    Item updateQuality(Item item);

    Type getType();
}
