package com.pocketreddit.library.things;

import com.pocketreddit.library.things.Kind;
import com.pocketreddit.library.things.Thing;

public class Subreddit extends Thing {
    private static final long serialVersionUID = 1L;

    private String title;
    private String id;
    private String description;
    private String displayName;
    private boolean over18;
    private long numSubscribers;

    // private static String CLASS_NAME = Subreddit.class.getSimpleName();

    /**
     * The relative URL of the subreddit. Ex: "/r/pics/"
     */
    private String url;

    @Override
    public String toString() {
        return "Subreddit:\n=====\ndisplayName: " + displayName + "\nurl: " + url
                + "\nnumSubscribers: " + numSubscribers + "\nover18: " + over18 + "\ntitle: "
                + title + "\nid: " + id + "\n=====\n";
    }

    @Override
    public Kind getKind() {
        return Kind.SUBREDDIT;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubredditId() {
        return id;
    }

    public void setSubredditId(String subredditId) {
        this.id = subredditId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public long getNumSubscribers() {
        return numSubscribers;
    }

    public void setNumSubscribers(long numSubscribers) {
        this.numSubscribers = numSubscribers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
