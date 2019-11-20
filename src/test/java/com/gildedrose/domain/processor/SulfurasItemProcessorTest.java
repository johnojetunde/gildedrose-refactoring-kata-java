package com.gildedrose.domain.processor;

import com.gildedrose.domain.model.Item;
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
    public void processor_type_should_be_sulfuras() {
        assertEquals(Type.Sulfuras, processor.getType());
    }

    @Test
    public void quality_and_sellin_should_be_constant() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 15, 80);

        processor.updateQuality(item);

        assertEquals(15, item.sellIn);
        assertEquals(80, item.quality);
    }

}