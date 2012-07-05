package com.am05.reddit.library.datasources;

import org.json.JSONObject;

public interface JsonDataSource {
	public JSONObject getSubredditsForAccount(JSONObject account);

	public JSONObject getLinksForSubreddit(JSONObject subreddit);

	public JSONObject getCommentsForLink(JSONObject link);
	
	public JSONObject getSubreddit(String subreddit);
	
	public JSONObject getDefaultSubreddits();
}
