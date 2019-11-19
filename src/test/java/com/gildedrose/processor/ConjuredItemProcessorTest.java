package com.gildedrose.processor;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredItemProcessorTest {

    private ConjuredItemProcessor processor;

    @Before
    public void setUp() {
        processor = new ConjuredItemProcessor();
    }


    @Test
    public void processor_type_should_be_conjured() {
        assertEquals(Type.Conjured, processor.getType());
    }

    @Test
    public void quality_should_reduce_by_2_when_item_is_Conjured() {
        Item item = new Item("Conjured Mana Cake", 15, 30);

        processor.updateQuality(item);

        assertEquals(14,item.sellIn);
        assertEquals(28,item.quality);
    }


    @Test
    public void quality_should_not_go_lower_than_0() {
        Item item = new Item("Conjured Mana Cake", 13, 0);

        processor.updateQuality(item);

        assertEquals(12,item.sellIn);
        assertEquals(0,item.quality);
    }
}