package com.gildedrose.persistence.repository;

import com.gildedrose.domain.exception.ItemRetrievalException;
import com.gildedrose.domain.model.Item;
import com.gildedrose.domain.service.GetItems;
import com.google.gson.Gson;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GetItemsFromElasticSearch implements GetItems {

    private final RestHighLevelClient client;

    private final Gson gson;


    @Autowired
    public GetItemsFromElasticSearch(RestHighLevelClient client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }


    @Override
    public List<Item> getAll() throws ItemRetrievalException {
        try {
            List<Item> items = new ArrayList<>();

            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices("items");

            SearchHits searchHits = client.search(searchRequest, RequestOptions.DEFAULT).getHits();

            searchHits.forEach(s -> {
                Item item = gson.fromJson(s.getSourceAsString(), Item.class);
                item.setId(s.getId());
                items.add(item);
            });

            return items;
        } catch (IOException e) {
            throw new ItemRetrievalException("Error encountered while trying to fetch all items", e);
        }
    }
}
