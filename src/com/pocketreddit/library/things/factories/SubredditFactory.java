package com.pocketreddit.library.things.factories;

import org.json.JSONException;
import org.json.JSONObject;

import com.pocketreddit.library.things.Subreddit;

public class SubredditFactory implements ThingFactory {
    private JSONObject json;

    public SubredditFactory(JSONObject json) {
        this.json = json;
    }

    public Subreddit createThing() throws ThingFactoryException {
        try {
            JSONObject data = json.getJSONObject("data");
            Subreddit subreddit = new Subreddit();
            subreddit.setDisplayName(data.getString("display_name"));
            subreddit.setDescription(data.getString("description"));
            subreddit.setUrl(data.getString("url"));
            subreddit.setNumSubscribers(data.getInt("subscribers"));
            subreddit.setOver18(data.getBoolean("over18"));
            subreddit.setTitle(data.getString("title"));
            subreddit.setId(data.getString("id"));

            return subreddit;
        } catch (JSONException e) {
            throw new ThingFactoryException("Failed trying to parse JSON object into Subreddit: "
                    + e.getMessage(), e);
        }
    }
}
