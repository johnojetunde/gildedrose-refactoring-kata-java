package com.gildedrose.domain.service;

public class ItemQualityConstraint {
    private ItemQualityConstraint() {
    }

    public static int ensureRange(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }
}
