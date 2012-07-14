package com.pocketreddit.library.things.factories;

public class ThingFactoryException extends Exception {
    private static final long serialVersionUID = 1L;

    public ThingFactoryException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ThingFactoryException(String message) {
        super(message);
    }
}
