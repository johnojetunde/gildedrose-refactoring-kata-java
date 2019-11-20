package com.gildedrose.app.controller;

import com.gildedrose.domain.exception.ItemServiceException;
import com.gildedrose.domain.model.Item;
import com.gildedrose.domain.service.ItemRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemRetriever retriever;

    @Autowired
    public ItemController(ItemRetriever retriever) {
        this.retriever = retriever;
    }

    @GetMapping("")
    public List<Item> retrieveItem() throws ItemServiceException {
        return retriever.retrieveItems();
    }

}
