package com.gildedrose.domain.service;

import com.gildedrose.domain.exception.ItemRetrievalException;
import com.gildedrose.domain.exception.ItemServiceException;
import com.gildedrose.domain.fixture.ItemFixture;
import com.gildedrose.domain.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

class ItemRetrieverServiceTest {

    @Mock
    private GetItems storage;

    @InjectMocks
    private ItemRetrieverService retrieverService;

    private List<Item> items;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        items = ItemFixture.itemList().subList(0, 3);
    }


    @Test
    void should_throw_exception_when_retrieval_from_surce_failed() throws ItemRetrievalException {
        doAnswer(invocation -> {
            throw new ItemRetrievalException("Unable to retrieve from source");
        }).when(storage).getAll();

        assertThrows(ItemServiceException.class, () -> retrieverService.retrieveItems());
    }

    @Test
    void should_retrieve_items_successfully() throws ItemRetrievalException, ItemServiceException {
        when(storage.getAll()).thenReturn(items.subList(0, 3));

        List<Item> result = retrieverService.retrieveItems();

        assertEquals(items, result);
    }
}