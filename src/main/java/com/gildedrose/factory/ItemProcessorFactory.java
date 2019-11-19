package com.gildedrose.factory;

import com.gildedrose.model.Item;
import com.gildedrose.processor.ItemProcessor;
import com.gildedrose.processor.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemProcessorFactory {

    private final List<ItemProcessor> processors;

    private static final Map<Type, ItemProcessor> processorCache = new HashMap<>();

    @Autowired
    public ItemProcessorFactory(List<ItemProcessor> processors) {
        this.processors = processors;
    }

    @PostConstruct
    public void initProcessorCache() {
        processors.forEach(p ->
                processorCache.put(p.getType(), p)
        );
    }

    public ItemProcessor getProcessor(Item item) {
        return processorCache.get(Type.getType(item.name));
    }
}
