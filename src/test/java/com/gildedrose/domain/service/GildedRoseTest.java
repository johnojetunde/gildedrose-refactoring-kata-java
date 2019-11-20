package com.gildedrose.domain.service;

import com.gildedrose.domain.fixture.ItemFixture;
import com.gildedrose.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class GildedRoseTest {

    @Autowired
    private GildedRose app;

    private List<Item> items;

    @BeforeEach
    void setUp() {
        items = ItemFixture.itemList();
    }

    @Test
    void update_quality() {
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


}