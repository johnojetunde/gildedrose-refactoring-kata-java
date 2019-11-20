package com.gildedrose.domain.service;

import com.gildedrose.domain.exception.ItemRetrievalException;
import com.gildedrose.domain.exception.ItemServiceException;
import com.gildedrose.domain.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemRetrieverService implements ItemRetriever {

    private final GetItems storage;

    @Autowired
    public ItemRetrieverService(GetItems itemStorage) {
        this.storage = itemStorage;
    }

    @Override
    public List<Item> retrieveItems() throws ItemServiceException {
        try {
            return storage.getAll();
        } catch (ItemRetrievalException e) {
            throw new ItemServiceException("Unable to retrieve all items", e);
        }
    }
}
