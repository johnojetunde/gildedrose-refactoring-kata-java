package com.gildedrose.processor;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AgedBrieItemProcessorTest {

    private AgedBrieItemProcessor processor;

    @Before
    public void setUp() {
        processor = new AgedBrieItemProcessor();
    }

    @Test
    public void processor_type_should_be_aged_brie() {
        assertEquals(Type.Aged_Brie, processor.getType());
    }

    @Test
    public void quality_should_increase_and_sellin_decrease() {
        Item item = new Item("Aged Brie", 15, 7);

        processor.updateQuality(item);

        assertEquals(14,item.sellIn);
        assertEquals(8,item.quality);
    }

    @Test
    public void quality_should_not_go_higher_than_50() {
        Item item = new Item("Aged Brie", 15, 50);

        processor.updateQuality(item);

        assertEquals(14,item.sellIn);
        assertEquals(50,item.quality);
    }

}
