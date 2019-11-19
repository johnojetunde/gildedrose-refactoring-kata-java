package com.gildedrose.processor;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasItemProcessorTest {

    private SulfurasItemProcessor processor;

    @Before
    public void setUp() {
        processor = new SulfurasItemProcessor();
    }

    @Test
    public void quality_and_sellin_should_be_constant() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 15, 80);

        processor.updateQuality(item);

        assertEquals(15, item.sellIn);
        assertEquals(80, item.quality);
    }

}