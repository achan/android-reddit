package com.am05.reddit.library.datasources;

public class DataSourceException extends Exception {
    private static final long serialVersionUID = 1L;

    public DataSourceException(String message) {
        super(message);
    }

    public DataSourceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
