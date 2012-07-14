package com.pocketreddit.library.datasources;

import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.pocketreddit.library.datasources.DataSourceException;
import com.pocketreddit.library.datasources.RedditDataSource;
import com.pocketreddit.library.things.Link;
import com.pocketreddit.library.things.Subreddit;
import com.pocketreddit.library.things.Thing;

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
            List<Subreddit> subreddits = ds.getSubreddits(null).getChildren();
            for (Subreddit subreddit : subreddits) {
                Log.v(TAG, "subreddit: " + subreddit.getDisplayName());
            }
        } catch (DataSourceException e) {
            logAndFail("failed to get subreddits", e);
        }
    }

    public void testGetLinksForSubreddit() {
        try {
            getLinksForSubreddits("askreddit", "nba", "videos", "programming");
        } catch (DataSourceException e) {
            logAndFail("failed to get links for subreddit", e);
        }
    }

    private void getLinksForSubreddits(String... subreddits) throws DataSourceException {
        for (String subreddit : subreddits) {
            List<Link> links = ds.getLinksForSubreddit(subreddit).getChildren();
            for (Link link : links) {
                Log.v(TAG, "link: " + link);
            }
        }
    }

    public void testGetCommentsForLink() {
        try {
            Link link = new Link();
            link.setPermalink("/r/politics/comments/wf1t2/melinda_gates_pledges_560000000_for_contraception/");
            List<? extends Thing> comments = ds.getCommentsForLink(link).getChildren();

            for (Thing comment : comments) {
                Log.v(TAG, "comment: " + comment);
            }
        } catch (DataSourceException e) {
            logAndFail("Failed to get comments for link", e);
        }
    }

    public void testGetSubreddit() {
        try {
            Subreddit subreddit = ds.getSubreddit("programming");
            Log.v(TAG, "subreddit programming found: " + subreddit);
        } catch (DataSourceException e) {
            logAndFail("Could not get subreddit.", e);
        }
    }

    public void testGetDefaultSubreddits() {
        try {
            List<Subreddit> subreddits = ds.getDefaultSubreddits().getChildren();
            for (Subreddit subreddit : subreddits) {
                Log.v(TAG, "subreddit: " + subreddit.getDisplayName());
            }
        } catch (DataSourceException e) {
            logAndFail("failed to get default subreddits", e);
        }
    }

    private void logAndFail(String message, Throwable t) {
        Log.e(TAG, message, t);
        fail(message);
    }
}
