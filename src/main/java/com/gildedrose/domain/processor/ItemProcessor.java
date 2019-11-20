package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;

public interface ItemProcessor {
    void updateQuality(Item item);

    Type getType();
}
