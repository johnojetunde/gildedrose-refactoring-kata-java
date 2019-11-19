package com.gildedrose.processor;

public enum Type {
    Backstage_Passes,
    Aged_Brie,
    Sulfuras,
    Conjured,
    Default;

    public static Type getType(String s) {
        Type type;
        if (s.contains("Backstage passes")) {
            type = Type.Backstage_Passes;
        } else if (s.contains("Aged Brie")) {
            type = Type.Aged_Brie;
        } else if (s.contains("Sulfuras")) {
            type = Type.Sulfuras;
        } else if (s.contains("Conjured")) {
            type = Type.Conjured;
        } else {
            type = Type.Default;
        }
        return type;
    }
}
