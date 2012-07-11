package com.am05.reddit.library.datasources;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.json.JSONObject;

import com.am05.reddit.library.net.HttpHelper;
import com.am05.reddit.library.net.NetException;

public class LiveDataSource implements JsonDataSource {
    private static final String COOKIE_KEY_REDDIT_SESSION = "reddit_session";
    private static final String URI_BASE = "http://www.reddit.com";
    private static final String URI_SUBREDDIT_PREFIX = URI_BASE + "/r/";
    private static final String URI_SUBREDDITS = URI_BASE + "/reddits.json";

    public JSONObject getSubreddits(String sessionId) throws DataSourceException {
        Cookie cookie = new BasicClientCookie(COOKIE_KEY_REDDIT_SESSION, sessionId);
        List<Cookie> cookies = new ArrayList<Cookie>();
        cookies.add(cookie);
        try {
            return HttpHelper.getInstance().getJsonFromGet(URI_SUBREDDITS, cookies);
        } catch (NetException e) {
            throw new DataSourceException(
                    "error trying to parse JSON from GET @ " + URI_SUBREDDITS, e);
        }
    }

    public JSONObject getLinks(String subreddit) throws DataSourceException {
        String subredditUrl = URI_SUBREDDIT_PREFIX + subreddit + ".json";
        try {
            return HttpHelper.getInstance().getJsonFromGet(subredditUrl);
        } catch (NetException e) {
            throw new DataSourceException("could not get JSON response from: " + subredditUrl, e);
        }
    }

    public JSONObject getComments(String permalink) {
        // TODO Auto-generated method stub
        return null;
    }

    public JSONObject getSubreddit(String subreddit) {
        // TODO Auto-generated method stub
        return null;
    }

    public JSONObject getDefaultSubreddits() throws DataSourceException {
        try {
            return HttpHelper.getInstance().getJsonFromGet(URI_SUBREDDITS);
        } catch (NetException e) {
            throw new DataSourceException("could not get JSON response from: " + URI_SUBREDDITS, e);
        }
    }
}
