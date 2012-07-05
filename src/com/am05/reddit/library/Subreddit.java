package com.am05.reddit.library;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Subreddit extends Listing {
    private static final String TAG = Subreddit.class.getName();

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

    public Subreddit() {
    }

    public Subreddit(JSONObject json) throws JSONException {
        JSONObject data = json.getJSONObject("data");
        displayName = data.getString("display_name");
        description = data.getString("description");
        url = data.getString("url");
        numSubscribers = data.getInt("subscribers");
        over18 = data.getBoolean("over18");
        title = data.getString("title");
        id = data.getString("id");
    }

    @Override
    public String toString() {
        return "Subreddit:\n=====\ndisplayName: " + displayName + "\nurl: " + url
                + "\nnumSubscribers: " + numSubscribers + "\nover18: " + over18 + "\ntitle: "
                + title + "\nid: " + id + "\n=====\n";
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

    public static List<Subreddit> fromJson(JSONObject jsonSubreddits) throws JSONException {
        List<Subreddit> subreddits = new ArrayList<Subreddit>();
        JSONObject data = jsonSubreddits.getJSONObject("data");
        JSONArray children = data.getJSONArray("children");

        for (int i = 0; i < children.length(); i++) {
            subreddits.add(new Subreddit(children.getJSONObject(i)));
        }

        return subreddits;
    }

    public JSONObject toJson() {
        throw new UnsupportedOperationException("unsupported");
    }
}
