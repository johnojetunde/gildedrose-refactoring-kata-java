package com.gildedrose.domain.service;

import com.gildedrose.domain.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GildedRoseTest {

    @Autowired
    private GildedRose app;

    private List<Item> items;

    @Before
    public void setUp() {
        items = items();
    }

    @Test
    public void update_quality() {
        app.updateQuality(items);

        assertEquals("+5 Dexterity Vest, 9, 19", items.get(0).toString());
        assertEquals("Aged Brie, 1, 1", items.get(1).toString());
        assertEquals("Elixir of the Mongoose, -2, 5", items.get(2).toString());
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items.get(3).toString());
        assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items.get(4).toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", items.get(5).toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 50", items.get(6).toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 50", items.get(7).toString());
        assertEquals("Conjured Mana Cake, 2, 4", items.get(8).toString());
    }

    private List<Item> items() {
        return new ArrayList<Item>() {{
            add(new Item("+5 Dexterity Vest", 10, 20));
            add(new Item("Aged Brie", 2, 0));
            add(new Item("Elixir of the Mongoose", -1, 7));
            add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
            add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
            add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
            add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
            add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
            add(new Item("Conjured Mana Cake", 3, 6));
        }};
    }


}