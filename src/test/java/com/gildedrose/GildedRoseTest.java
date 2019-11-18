package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void should_decrease_quality_by_1_daily() {
        Item[] items = new Item[]{new Item("Random Product", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Random Product, 1, 49", items[0].toString());
    }

    @Test
    public void should_decrease_quality_by_2_when_sellin_is_less_than_0() {
        Item[] items = new Item[]{new Item("Another Product", -1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Another Product, -2, 48", items[0].toString());
    }

    @Test
    public void should_increase_quality_and_decrease_sellin_when_item_is_Aged_Brie() {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie, 14, 8", items[0].toString());
    }

    @Test
    public void should_increase_quality_by_2_when_item_is_Aged_Brie_and_sellin_is_0_or_less() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie, -2, 9", items[0].toString());
    }


    @Test
    public void should_not_increase_quality_when_quality_is_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie, 14, 50", items[0].toString());
    }


    @Test
    public void should_have_constant_quality_sellin_when_item_is_Sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 15, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros, 15, 80", items[0].toString());
    }


    @Test
    public void should_have_0_quality_when_item_is_Backstage_and_sellin_is_0__or_less() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", items[0].toString());
    }

    @Test
    public void quality_should_incease_by_2_when_item_is_Backstage_and_sellin_is_10_or_less_but_greater_than_5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 32", items[0].toString());
    }

    @Test
    public void quality_should_incease_by_2_when_item_is_Backstage_and_sellin_is_5_or_less_but_greater_than_0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 33", items[0].toString());
    }

    @Test
    public void quality_should_incease_by_1_when_item_is_Backstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 31", items[0].toString());
    }


    @Test
    public void quality_should_reduce_by_2_when_item_is_Conjured() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 15, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Conjured Mana Cake, 14, 28", items[0].toString());
    }

}