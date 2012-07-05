package com.am05.reddit.library;

import android.test.AndroidTestCase;
import android.util.Log;

import com.am05.reddit.library.net.HttpHelper;

public class IntegrationSubredditTest extends AndroidTestCase {
	public void testGetSubreddit() {
		try {
			Log.v(this.getClass().getName(), new Subreddit(HttpHelper
					.getInstance()
					.getJson("http://reddit.com/r/nba/about.json")).toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
