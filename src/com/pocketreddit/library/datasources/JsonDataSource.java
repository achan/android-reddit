package com.pocketreddit.library.datasources;

import org.json.JSONObject;

public interface JsonDataSource {
	public JSONObject getSubreddits(String sessionId) throws DataSourceException;

	public JSONObject getLinks(String subreddit) throws DataSourceException;

	public JSONObject getComments(String permalink) throws DataSourceException;
	
	public JSONObject getSubreddit(String subreddit) throws DataSourceException;
	
	public JSONObject getDefaultSubreddits() throws DataSourceException;
	
	public JSONObject getLinksForFrontPage() throws DataSourceException;
}
