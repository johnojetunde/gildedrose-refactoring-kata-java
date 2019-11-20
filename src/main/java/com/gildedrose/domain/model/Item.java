package com.gildedrose.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
public class Item {

    private String id;

    @NotBlank(message = "Name must not be blank")
    public String name;

    @Range(min = 1, message = "SellIn must be greater than 0")
    public int sellIn;

    @Range(min = 1, message = "Quality must be greater than 0")
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
