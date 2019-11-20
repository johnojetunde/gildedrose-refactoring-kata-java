package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;
import org.springframework.stereotype.Service;

@Service
public class SulfurasItemProcessor implements ItemProcessor {

    @Override
    public Item updateQuality(Item item) {
        return item;
    }

    @Override
    public Type getType() {
        return Type.Sulfuras;
    }
}
