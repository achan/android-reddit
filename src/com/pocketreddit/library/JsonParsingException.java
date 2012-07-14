package com.pocketreddit.library;

import org.json.JSONException;

public class JsonParsingException extends Exception {
    private static final long serialVersionUID = 1L;

    public JsonParsingException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public JsonParsingException(String message) {
        super(message);
    }
    
    public JsonParsingException(JSONException e) {
        super(e);
    }
}
