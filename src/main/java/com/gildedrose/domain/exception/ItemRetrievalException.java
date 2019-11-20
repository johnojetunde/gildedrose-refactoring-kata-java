package com.gildedrose.domain.exception;

public class ItemRetrievalException extends Exception {
    public ItemRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemRetrievalException(String message) {
        super(message);
    }
}
