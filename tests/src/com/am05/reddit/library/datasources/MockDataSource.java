package com.am05.reddit.library.datasources;

import java.io.IOException;
import java.io.InputStream;

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
		    InputStream is = context.getAssets().open("reddit.ds/mine.json");
            return new JSONObject(StreamUtils.getInstance().convertStreamToString(is));
        } catch (IOException e) {
            throw new DataSourceException("Could not open stream for json file.", e);
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse the JSON file.", e);
        }
	}

	public JSONObject getLinksForSubreddit(JSONObject subreddit) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject getCommentsForLink(JSONObject link) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject getSubreddit(String subreddit) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject getDefaultSubreddits() {
		// TODO Auto-generated method stub
		return null;
	}

}
