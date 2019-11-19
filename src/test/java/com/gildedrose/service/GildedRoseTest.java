package com.gildedrose.service;

import com.gildedrose.factory.ItemProcessorFactory;
import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private ItemProcessorFactory factory;

    @Before
    public void setUp() {
        factory = new ItemProcessorFactory();
    }

    @Test
    public void quality_and_sellin_should_decrease_by_1() {
        Item[] items = new Item[]{new Item("Random Product", 2, 50)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Random Product, 1, 49", items[0].toString());
    }

    @Test
    public void quality_should_decrease_by_2_when_sellin_is_less_than_0() {
        Item[] items = new Item[]{new Item("Another Product", -1, 50)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Another Product, -2, 48", items[0].toString());
    }

    @Test
    public void minimum_quality_should_be_0() {
        Item[] items = new Item[]{new Item("Another Product", -1, 0)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Another Product, -2, 0", items[0].toString());
    }

    @Test
    public void quality_and_sellin_decrease_when_item_is_Aged_Brie() {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 7)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Aged Brie, 14, 8", items[0].toString());
    }

    @Test
    public void quality_should_be_increased_by_2_when_item_is_Aged_Brie_and_sellin_is_0_or_less() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 7)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Aged Brie, -2, 9", items[0].toString());
    }


    @Test
    public void maximum_quality_should_be_50_for_all_items_except() {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 50)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Aged Brie, 14, 50", items[0].toString());
    }


    @Test
    public void quality_and_sellin_should_be_constant_when_item_is_Sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 15, 80)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros, 15, 80", items[0].toString());
    }


    @Test
    public void quality_should_be_0_when_item_is_Backstage_and_sellin_is_0__or_less() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 80)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", items[0].toString());
    }

    @Test
    public void quality_should_incease_by_2_when_item_is_Backstage_and_sellin_is_10_or_less_but_greater_than_5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 32", items[0].toString());
    }

    @Test
    public void quality_should_incease_by_2_when_item_is_Backstage_and_sellin_is_5_or_less_but_greater_than_0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 30)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 33", items[0].toString());
    }

    @Test
    public void quality_should_incease_by_1_when_item_is_Backstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 31", items[0].toString());
    }


    @Test
    public void quality_should_reduce_by_2_when_item_is_Conjured() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 15, 30)};
        GildedRose app = new GildedRose(items, factory);
        app.updateQuality();

        assertEquals("Conjured Mana Cake, 14, 28", items[0].toString());
    }

}