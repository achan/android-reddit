package com.am05.reddit.library.datasources;

import org.json.JSONObject;

public interface JsonDataSource {
	public JSONObject getSubreddits(String sessionId) throws DataSourceException;

	public JSONObject getLinksForSubreddit(JSONObject subreddit) throws DataSourceException;

	public JSONObject getCommentsForLink(JSONObject link) throws DataSourceException;
	
	public JSONObject getSubreddit(String subreddit) throws DataSourceException;
	
	public JSONObject getDefaultSubreddits() throws DataSourceException;
}
