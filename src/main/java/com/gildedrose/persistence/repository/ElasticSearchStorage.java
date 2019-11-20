package com.gildedrose.persistence.repository;

import com.gildedrose.domain.exception.ItemRetrievalException;
import com.gildedrose.domain.exception.ItemSaveException;
import com.gildedrose.domain.model.Item;
import com.gildedrose.domain.service.GetItems;
import com.gildedrose.domain.service.SaveItems;
import com.google.gson.Gson;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ElasticSearchStorage implements GetItems, SaveItems {

    private final RestHighLevelClient client;

    private final Gson gson;

    private final String indices;


    @Autowired
    public ElasticSearchStorage(RestHighLevelClient client, Gson gson,
                                @Qualifier("elastic.search.indices") String indices) {
        this.client = client;
        this.gson = gson;
        this.indices = indices;
    }


    @Override
    public List<Item> getAll() throws ItemRetrievalException {
        try {
            List<Item> items = new ArrayList<>();

            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices(indices);

            SearchHits searchHits = client.search(searchRequest, RequestOptions.DEFAULT).getHits();

            searchHits.forEach(s -> {
                Item item = gson.fromJson(s.getSourceAsString(), Item.class);
                item.setId(s.getId());
                items.add(item);
            });

            return items;
        } catch (IOException | ElasticsearchException e) {
            throw new ItemRetrievalException("Error encountered while trying to fetch all items", e);
        }
    }

    @Override
    public void save(List<Item> item) throws ItemSaveException {
        try {

            BulkRequest request = new BulkRequest();

            item.forEach(s -> request.add(
                    new UpdateRequest(indices, s.getId())
                            .doc(toMap(s))));


            BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);

            if (response.hasFailures()) {
                throw new ItemSaveException("Unable to perform complete bulk update");
            }
        } catch (Exception e) {
            throw new ItemSaveException("Error saving items", e);
        }
    }

    private Map<String, Object> toMap(Item item) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", item.name);
        map.put("sellIn", item.sellIn);
        map.put("quality", item.quality);

        return map;
    }
}
