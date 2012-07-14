package com.pocketreddit.library.utils;

public class UtilsException extends Exception {
    private static final long serialVersionUID = 1L;

    public UtilsException(String message) {
        super(message);
    }

    public UtilsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
