package com.gildedrose.domain.service;

import com.gildedrose.domain.exception.ItemSaveException;
import com.gildedrose.domain.model.Item;

import java.util.List;

public interface SaveItems {
    void save(List<Item> item) throws ItemSaveException;
}
