package com.am05.reddit.library.datasources;

import java.util.List;

import com.am05.reddit.library.Subreddit;

import android.test.AndroidTestCase;
import android.util.Log;

public class RedditDataSourceTest extends AndroidTestCase {
    private static final String TAG = RedditDataSourceTest.class.getName();
    private RedditDataSource ds;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ds = new RedditDataSource();
        ds.setDataSource(new MockDataSource(getContext()));
    }

    public void testGetSubreddits() {
        try {
            List<Subreddit> subreddits = ds.getSubreddits(null);
            for (Subreddit subreddit : subreddits) {
                Log.v(TAG, "subreddit: " + subreddit.getDisplayName());
            }
        } catch (DataSourceException e) {
            Log.e(TAG, "failed to get subreddits", e);
            fail("failed to get subreddits");
        }
    }
}
