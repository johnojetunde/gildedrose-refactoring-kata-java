package com.gildedrose.domain.service;

import com.gildedrose.domain.exception.ItemServiceException;
import com.gildedrose.domain.model.Item;

import java.util.List;

public interface ItemRetriever {
    List<Item> retrieveItems() throws ItemServiceException;
}
