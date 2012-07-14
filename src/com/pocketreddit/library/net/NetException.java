package com.pocketreddit.library.net;

public class NetException extends Exception {
    private static final long serialVersionUID = 1L;

    public NetException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
