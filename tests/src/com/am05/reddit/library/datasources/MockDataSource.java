package com.am05.reddit.library.datasources;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.am05.reddit.library.utils.StreamUtils;

public class MockDataSource implements JsonDataSource {
    private Context context;

    public MockDataSource(Context context) {
        this.context = context;
    }

    public JSONObject getSubreddits(String sessionId) throws DataSourceException {
        try {
            InputStream is = buildInputStream("/reddits/mine.json");
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse the JSON file.", e);
        }
    }

    public JSONObject getLinks(String subreddit) throws DataSourceException {
        try {
            InputStream is = buildInputStream("/r/" + subreddit + ".json");
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse the JSON file", e);
        }
    }

    public JSONArray getComments(String permalink) throws DataSourceException {
        try {
            InputStream is = buildInputStream(permalink.substring(0, permalink.length() - 1)
                    + ".json");
            return new JSONArray(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse JSON file.", e);
        }
    }

    public JSONObject getSubreddit(String subreddit) {
        // TODO Auto-generated method stub
        return null;
    }

    public JSONObject getDefaultSubreddits() {
        // TODO Auto-generated method stub
        return null;
    }

    private InputStream buildInputStream(String url) throws DataSourceException {
        try {
            return context.getAssets().open("reddit.ds" + url);
        } catch (IOException e) {
            throw new DataSourceException("Could not open stream for json file: " + url, e);
        }
    }
}
