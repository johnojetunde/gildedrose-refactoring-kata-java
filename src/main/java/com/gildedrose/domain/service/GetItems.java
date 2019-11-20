package com.gildedrose.domain.service;

import com.gildedrose.domain.exception.ItemRetrievalException;
import com.gildedrose.domain.model.Item;

import java.util.List;

public interface GetItems {
    List<Item> getAll() throws ItemRetrievalException;
}
