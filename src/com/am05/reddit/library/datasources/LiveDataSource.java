package com.am05.reddit.library.datasources;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

import com.am05.reddit.library.net.HttpHelper;
import com.am05.reddit.library.net.NetException;

public class LiveDataSource implements JsonDataSource {
    private static final String COOKIE_KEY_REDDIT_SESSION = "reddit_session";
    private static final String URI_SUBREDDITS = "http://www.reddit.com/reddits.json";

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

    public JSONObject getLinks(String subreddit) {
        // TODO Auto-generated method stub
        return null;
    }

    public JSONArray getComments(String permalink) {
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
