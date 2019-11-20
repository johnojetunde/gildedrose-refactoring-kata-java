package com.gildedrose.domain.fixture;

import com.gildedrose.domain.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemFixture {

    public static List<Item> itemList() {
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
