package com.gildedrose.domain.service;


import com.gildedrose.domain.exception.ItemSaveException;
import com.gildedrose.domain.exception.ItemServiceException;
import com.gildedrose.domain.fixture.ItemFixture;
import com.gildedrose.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class GildedRoseItemQualityUpdateTest {

    @Mock
    private ItemRetriever retriever;

    @Mock
    private SaveItems storage;

    @Mock
    private GildedRose gildedRose;

    @InjectMocks
    private GildedRoseItemQualityUpdate gildedRoseItemQualityUpdate;

    private List<Item> itemList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        itemList = ItemFixture.itemList();
    }

    @Test
    void should_throw_an_exception_when_storage_fails() throws ItemSaveException {
        doThrow(ItemSaveException.class).when(storage).save(anyList());

        assertThrows(ItemServiceException.class, () -> gildedRoseItemQualityUpdate.update());
    }

    @Test
    void should_throw_an_exception_when_quality_update_fails() {
        doThrow(RuntimeException.class).when(gildedRose).updateQuality(anyList());

        assertThrows(ItemServiceException.class, () -> gildedRoseItemQualityUpdate.update());
    }

    @Test
    void should_throw_an_exception_when_retrieval_fails() throws ItemServiceException {
        doThrow(ItemServiceException.class).when(retriever).retrieveItems();

        assertThrows(ItemServiceException.class, () -> gildedRoseItemQualityUpdate.update());
    }


    @Test
    void should_update_successfully() throws ItemSaveException {
        doAnswer(invocation -> {
            throw new ItemSaveException("Unable to save");
        }).when(storage).save(itemList);

        when(gildedRose.updateQuality(anyList())).thenReturn(itemList.subList(0, 3));

        assertDoesNotThrow(() -> gildedRoseItemQualityUpdate.update());
    }
}