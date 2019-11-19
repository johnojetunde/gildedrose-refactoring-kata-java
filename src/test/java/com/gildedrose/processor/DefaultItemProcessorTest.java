package com.gildedrose.processor;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultItemProcessorTest {

    private DefaultItemProcessor processor;

    @Before
    public void setUp() {
        processor = new DefaultItemProcessor();
    }

    @Test
    public void quality_and_sellin_should_decrease_by_1_when_sellin_is_greater_than_1() {
        Item item = new Item("Default Product", 2, 50);

        processor.updateQuality(item);

        assertEquals(1, item.sellIn);
        assertEquals(49, item.quality);
    }

    @Test
    public void quality_should_decrease_by_2_and_sellin_by_1_when_sellin_is_less_than_0() {
        Item item = new Item("Default Product", -1, 50);

        processor.updateQuality(item);

        assertEquals(-2, item.sellIn);
        assertEquals(48, item.quality);
    }

    @Test
    public void quality_should_not_go_lower_than_0() {
        Item item = new Item("Default Product", 13, 0);

        processor.updateQuality(item);

        assertEquals(12, item.sellIn);
        assertEquals(0, item.quality);
    }
}