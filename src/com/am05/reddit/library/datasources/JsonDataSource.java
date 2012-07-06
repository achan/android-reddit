package com.am05.reddit.library.datasources;

import org.json.JSONArray;
import org.json.JSONObject;

public interface JsonDataSource {
	public JSONObject getSubreddits(String sessionId) throws DataSourceException;

	public JSONObject getLinks(String subreddit) throws DataSourceException;

	public JSONArray getComments(String permalink) throws DataSourceException;
	
	public JSONObject getSubreddit(String subreddit) throws DataSourceException;
	
	public JSONObject getDefaultSubreddits() throws DataSourceException;
}
