package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AgedBrieItemProcessorTest {

    private AgedBrieItemProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new AgedBrieItemProcessor();
    }

    @Test
    void processor_type_should_be_aged_brie() {
        assertEquals(Type.Aged_Brie, processor.getType());
    }

    @Test
    void quality_should_increase_and_sellin_decrease() {
        Item item = new Item("Aged Brie", 15, 7);

        processor.updateQuality(item);

        assertEquals(14, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void quality_should_not_go_higher_than_50() {
        Item item = new Item("Aged Brie", 15, 50);

        processor.updateQuality(item);

        assertEquals(14, item.sellIn);
        assertEquals(50, item.quality);
    }

}
