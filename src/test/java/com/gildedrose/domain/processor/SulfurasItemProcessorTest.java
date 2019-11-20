package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemProcessorTest {

    private SulfurasItemProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new SulfurasItemProcessor();
    }


    @Test
    void processor_type_should_be_sulfuras() {
        assertEquals(Type.Sulfuras, processor.getType());
    }

    @Test
    void quality_and_sellin_should_be_constant() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 15, 80);

        processor.updateQuality(item);

        assertEquals(15, item.sellIn);
        assertEquals(80, item.quality);
    }

}