package com.pocketreddit.library.things;

import java.io.Serializable;

import com.pocketreddit.library.things.Kind;

public abstract class Thing implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public abstract Kind getKind();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
