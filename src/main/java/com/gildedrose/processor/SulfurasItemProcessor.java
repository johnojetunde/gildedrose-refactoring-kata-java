package com.gildedrose.processor;

import com.gildedrose.model.Item;
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
