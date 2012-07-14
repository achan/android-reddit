package com.am05.reddit.library;

import android.test.AndroidTestCase;
import android.util.Log;

import com.am05.reddit.library.net.HttpHelper;
import com.am05.reddit.library.things.Subreddit;
import com.am05.reddit.library.things.utils.JsonToThingConverter;

public class IntegrationSubredditTest extends AndroidTestCase {
    public void testGetSubreddit() {
        try {
            Log.v(this.getClass().getName(),
                    new JsonToThingConverter<Subreddit>().convert(
                            HttpHelper.getInstance().getJsonObjectFromGet(
                                    "http://reddit.com/r/nba/about.json")).toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
