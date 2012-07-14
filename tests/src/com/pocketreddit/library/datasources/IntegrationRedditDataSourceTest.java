package com.pocketreddit.library.datasources;

import android.test.AndroidTestCase;
import android.util.Log;

import com.pocketreddit.library.datasources.DataSourceException;
import com.pocketreddit.library.datasources.RedditDataSource;
import com.pocketreddit.library.things.Link;

public class IntegrationRedditDataSourceTest extends AndroidTestCase {
    private static final String TAG = IntegrationRedditDataSourceTest.class.getName();
    private final RedditDataSource DS = new RedditDataSource();

    /*
     * public void testGetSubreddits() { RedditDataSource ds = new
     * RedditDataSource(); try {
     * ds.getSubreddits("3acfec8427be44b0b90970d59a56e1b50ff74adf"); } catch
     * (DataSourceException e) { Log.e(TAG, "Couldn't get subreddits", e);
     * fail("Could not get subreddits."); } }
     */

    public void testGetComments() {
        Link link = new Link();
        link.setPermalink("/r/AskReddit/comments/wj9de/today_i_gave_a_10_tip_to_a_pizza_delivery_man_he/");
        try {
            DS.getCommentsForLink(link);
        } catch (DataSourceException e) {
            Log.e(TAG, "Could not get comments for link: " + e.getMessage(), e);
            fail("Could not get comments for link: " + e.getMessage());
        }
    }
}
