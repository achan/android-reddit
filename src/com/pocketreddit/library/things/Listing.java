package com.pocketreddit.library.things;

import java.util.List;

import com.pocketreddit.library.things.Kind;
import com.pocketreddit.library.things.Thing;

public class Listing<T extends Thing> extends Thing {
    private static final long serialVersionUID = 1L;

    /**
     * A list of things that this Listing wraps.
     */
    private List<T> children;

    /**
     * The full name of the listing that precedes this page. Null, if there is
     * no previous.
     */
    private String before;

    /**
     * The fullname of the listing that follows after this page. null if there
     * is no next page.
     */
    private String after;

    /**
     * This modhash is not the same modhash provided upon login. You do not need
     * to update your user's modhash everytime you get a new modhash. You can
     * reuse the modhash given upon login.
     */
    private String modHash;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getModHash() {
        return modHash;
    }

    public void setModHash(String modHash) {
        this.modHash = modHash;
    }

    @Override
    public Kind getKind() {
        return Kind.LISTING;
    }
}
