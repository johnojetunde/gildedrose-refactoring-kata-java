package com.gildedrose.service;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GildedRoseTest {

    @Autowired
    private GildedRose app;

    private Item[] items;

    @Before
    public void setUp() {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", -1, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};
    }

    @Test
    public void update_quality() {
        app.updateQuality(items);

        assertEquals("+5 Dexterity Vest, 9, 19", items[0].toString());
        assertEquals("Aged Brie, 1, 1", items[1].toString());
        assertEquals("Elixir of the Mongoose, -2, 5", items[2].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString());
        assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", items[5].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 50", items[6].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 50", items[7].toString());
        assertEquals("Conjured Mana Cake, 2, 4", items[8].toString());
    }
}