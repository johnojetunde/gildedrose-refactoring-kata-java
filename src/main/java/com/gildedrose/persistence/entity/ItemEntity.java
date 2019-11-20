package com.gildedrose.persistence.entity;

import com.gildedrose.domain.model.Item;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemEntity {

    private String id;

    private String name;

    private int sellIn;

    private int quality;

    public Item toItem() {
        return new Item(this.name, this.sellIn, this.quality);
    }
}
