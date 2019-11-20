package com.gildedrose.domain.service;

import com.gildedrose.domain.exception.ItemSaveException;
import com.gildedrose.domain.exception.ItemServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GildedRoseItemQualityUpdate implements ItemQualityUpdate {

    private final ItemRetriever retriever;

    private final GildedRose gildedRose;

    private final SaveItems storage;

    @Autowired
    public GildedRoseItemQualityUpdate(ItemRetriever retriever, GildedRose gildedRose, SaveItems storage) {
        this.retriever = retriever;
        this.gildedRose = gildedRose;
        this.storage = storage;
    }

    @Override
    public void update() throws ItemServiceException {
        try {
            storage.save(
                    gildedRose.updateQuality(
                            retriever.retrieveItems()));
        } catch (ItemSaveException e) {
            throw new ItemServiceException("Unable to save updated items", e);
        }
    }
}
