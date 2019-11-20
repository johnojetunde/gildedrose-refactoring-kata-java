package com.gildedrose.persistence.repository;

import com.gildedrose.domain.exception.ItemSaveException;
import com.gildedrose.domain.model.Item;
import com.gildedrose.domain.service.SaveItems;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SaveItemsInElasticSearch implements SaveItems {

    private final RestHighLevelClient client;


    @Autowired
    public SaveItemsInElasticSearch(RestHighLevelClient client) {
        this.client = client;
    }

    @Override
    public void save(List<Item> item) throws ItemSaveException {
        try {

            BulkRequest request = new BulkRequest();

            item.forEach(s -> request.add(
                    new UpdateRequest("items", s.getId())
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
