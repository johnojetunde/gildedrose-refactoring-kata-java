package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemProcessorTest {

    private ConjuredItemProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new ConjuredItemProcessor();
    }


    @Test
    void processor_type_should_be_conjured() {
        assertEquals(Type.Conjured, processor.getType());
    }

    @Test
    void quality_should_reduce_by_2_when_item_is_Conjured() {
        Item item = new Item("Conjured Mana Cake", 15, 30);

        processor.updateQuality(item);

        assertEquals(14, item.sellIn);
        assertEquals(28, item.quality);
    }


    @Test
    void quality_should_not_go_lower_than_0() {
        Item item = new Item("Conjured Mana Cake", 13, 0);

        processor.updateQuality(item);

        assertEquals(12, item.sellIn);
        assertEquals(0, item.quality);
    }
}