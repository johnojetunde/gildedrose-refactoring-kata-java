package com.gildedrose.processor;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BackstagePassesItemProcessorTest {

    private BackstagePassesItemProcessor processor;

    @Before
    public void setUp() {
        processor = new BackstagePassesItemProcessor();
    }

    @Test
    public void processor_type_should_be_backstage_passes() {
        assertEquals(Type.Backstage_Passes, processor.getType());
    }


    @Test
    public void quality_should_be_0_when_sellin_is_0_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);

        processor.updateQuality(item);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void quality_should_increase_by_2_when_sellin_is_10_or_less_and_sellin_is_greater_than_5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30);

        processor.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(32, item.quality);
    }

    @Test
    public void quality_should_increase_by_2_when_sellin_is_5_or_less_and_sellin_is_greater_than_0() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 30);

        processor.updateQuality(item);

        assertEquals(3, item.sellIn);
        assertEquals(33, item.quality);
    }

    @Test
    public void quality_should_increase_by_1_when_sellin_is_greater_than_10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30);

        processor.updateQuality(item);

        assertEquals(14, item.sellIn);
        assertEquals(31, item.quality);
    }

    @Test
    public void quality_should_not_go_higher_than_50() {
        Item item = new Item("Backstage passes", 9, 50);

        processor.updateQuality(item);

        assertEquals(8, item.sellIn);
        assertEquals(50, item.quality);
    }

}
