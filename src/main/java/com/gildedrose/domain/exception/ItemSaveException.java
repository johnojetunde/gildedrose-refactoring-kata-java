package com.gildedrose.domain.exception;

public class ItemSaveException extends Exception {

    public ItemSaveException(String message) {
        super(message);
    }

    public ItemSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
