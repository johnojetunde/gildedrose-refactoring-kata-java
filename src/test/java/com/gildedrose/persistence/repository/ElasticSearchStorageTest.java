package com.gildedrose.persistence.repository;

import com.gildedrose.domain.exception.ItemRetrievalException;
import com.gildedrose.domain.exception.ItemSaveException;
import com.gildedrose.domain.model.Item;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ElasticSearchStorageTest {


    private ElasticSearchStorage elasticSearch;

    private static String index;

    private static RestHighLevelClient client;

    @BeforeEach
    void setUp() {

        client = getClient();

        index = "testindices";

        elasticSearch = new ElasticSearchStorage(client, new GsonBuilder().create(), index);
    }

    @Test
    void should_throw_an_exception_when_indices_does_not_exist() {
        assertThrows(ItemRetrievalException.class, () -> elasticSearch.getAll());
    }

    @Test
    void should_retrieve_all_items_from_elastic_search() throws IOException, ItemRetrievalException, InterruptedException {
        saveNewItem();

        sleep(1);

        List<Item> items = elasticSearch.getAll();

        assertEquals(1, items.size());
        assertEquals("1", items.get(0).getId());
    }

    @Test
    void should_update_item_successfully() throws IOException, ItemSaveException, ItemRetrievalException, InterruptedException {
        saveNewItem();

        Item item = new Item("Aged Brie", 2, 3);
        item.setId("1");

        elasticSearch.save(Collections.singletonList(item));

        sleep(1);

        List<Item> items = elasticSearch.getAll();

        Item retrievedItem = items.get(0);
        assertEquals(3, retrievedItem.getQuality());
        assertEquals(2, retrievedItem.getSellIn());
        assertEquals("Aged Brie", retrievedItem.getName());
    }


    @AfterAll
    static void tearDown() throws IOException {
        client.indices().delete(
                new DeleteIndexRequest().indices(index),
                RequestOptions.DEFAULT);
    }


    private void sleep(int seconds) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
    }

    private void saveNewItem() throws IOException {
        client.index(new IndexRequest(index)
                .source(new HashMap<String, Object>() {{
                    put("id", 1);
                    put("name", "name");
                    put("sellIn", 0);
                    put("quality", 15);
                }}).id("1"), RequestOptions.DEFAULT);

    }

    private static RestHighLevelClient getClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", Integer.parseInt("9200")));
        return new RestHighLevelClient(builder);
    }
}