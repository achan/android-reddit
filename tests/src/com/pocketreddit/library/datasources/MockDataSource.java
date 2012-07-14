package com.pocketreddit.library.datasources;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.pocketreddit.library.datasources.DataSourceException;
import com.pocketreddit.library.datasources.JsonDataSource;
import com.pocketreddit.library.utils.StreamUtils;
import com.pocketreddit.library.utils.UtilsException;

public class MockDataSource implements JsonDataSource {
    private Context context;

    public MockDataSource(Context context) {
        this.context = context;
    }

    public JSONObject getSubreddits(String sessionId) throws DataSourceException {
        InputStream is = buildInputStream("/reddits/mine.json");
        try {
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse the JSON file.", e);
        } catch (UtilsException e) {
            throw new DataSourceException("Couldn't convert stream to String.", e);
        }
    }

    public JSONObject getLinks(String subreddit) throws DataSourceException {
        InputStream is = buildInputStream("/r/" + subreddit + ".json");
        try {
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse the JSON file", e);
        } catch (UtilsException e) {
            throw new DataSourceException("Couldn't convert stream to String.", e);
        }
    }

    public JSONObject getComments(String permalink) throws DataSourceException {
        InputStream is = buildInputStream(permalink.substring(0, permalink.length() - 1) + ".json");
        try {
            // 1st item in array is OP
            return new JSONArray(StreamUtils.getInstance().convertStreamToString(is))
                    .getJSONObject(1);
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse JSON file.", e);
        } catch (UtilsException e) {
            throw new DataSourceException("Couldn't convert stream to String.", e);
        }
    }

    public JSONObject getSubreddit(String subreddit) throws DataSourceException {
        InputStream is = buildInputStream("/r/" + subreddit + "/about.json");
        try {
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse JSON file", e);
        } catch (UtilsException e) {
            throw new DataSourceException("Couldn't convert stream to String.", e);
        }
    }

    public JSONObject getDefaultSubreddits() throws DataSourceException {
        InputStream is = buildInputStream("/reddits.json");
        try {
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse JSON file.", e);
        } catch (UtilsException e) {
            throw new DataSourceException("Couldn't convert stream to String.", e);
        }
    }

    private InputStream buildInputStream(String url) throws DataSourceException {
        try {
            return context.getAssets().open("reddit.ds" + url);
        } catch (IOException e) {
            throw new DataSourceException("Could not open stream for json file: " + url, e);
        }
    }

    @Override
    public JSONObject getLinksForFrontPage() throws DataSourceException {
        InputStream is = buildInputStream("/.json");
        try {
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse the JSON file", e);
        } catch (UtilsException e) {
            throw new DataSourceException("Couldn't convert stream to String.", e);
        }
    }
}
