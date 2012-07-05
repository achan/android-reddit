package com.am05.reddit.library.datasources;

import com.am05.reddit.library.datasources.RedditDataSource.Environment;

import android.test.AndroidTestCase;

public class RedditDataSourceTest extends AndroidTestCase {
    private RedditDataSource ds;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ds = new RedditDataSource(Environment.TEST);
    }
}
