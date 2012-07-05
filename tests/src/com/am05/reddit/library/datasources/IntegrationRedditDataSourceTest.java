package com.am05.reddit.library.datasources;

import android.test.AndroidTestCase;
import android.util.Log;

public class IntegrationRedditDataSourceTest extends AndroidTestCase {
    private static final String TAG = IntegrationRedditDataSourceTest.class.getName();

    public void testGetSubreddits() {
        RedditDataSource ds = new RedditDataSource();
        try {
            ds.getSubreddits("3acfec8427be44b0b90970d59a56e1b50ff74adf");
        } catch (DataSourceException e) {
            Log.e(TAG, "Couldn't get subreddits", e);
            fail("Could not get subreddits.");
        }
    }
}
