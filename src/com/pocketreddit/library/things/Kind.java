package com.pocketreddit.library.things;

import com.pocketreddit.library.things.Kind;

public enum Kind {
    COMMENT("t1"), THREAD("t3"), MESSAGE("t4"), SUBREDDIT("t5"), MORE("more"), LISTING("Listing");

    private String id;

    private Kind(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Kind toKind(String id) {
        for (Kind kind : Kind.values()) {
            if (kind.id.equals(id))
                return kind;
        }

        throw new IllegalArgumentException("Could not find kind for id: " + id);
    }
}
