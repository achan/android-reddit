package com.am05.reddit.library.datasources;

import java.util.List;

import org.json.JSONException;

import com.am05.reddit.library.Comment;
import com.am05.reddit.library.Link;
import com.am05.reddit.library.Subreddit;

public class RedditDataSource {
    private JsonDataSource dataSource;

    public RedditDataSource() {
        dataSource = new LiveDataSource();
    }

    public List<Subreddit> getSubreddits(String sessionId) throws DataSourceException {
        try {
            return Subreddit.fromJson(dataSource.getSubreddits(sessionId));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse subreddits from JSON.", e);
        }
    }

    public List<Link> getLinksForSubreddit(Subreddit subreddit) throws DataSourceException {
        return Link.fromJson(dataSource.getLinksForSubreddit(subreddit.toJson()));
    }

    public List<Comment> getCommentsForLink(Link link) throws DataSourceException {
        return Comment.fromJson(dataSource.getCommentsForLink(link.toJson()));
    }

    public Subreddit getSubreddit(String subreddit) throws DataSourceException {
        return new Subreddit(dataSource.getSubreddit(subreddit));
    }

    public List<Subreddit> getDefaultSubreddits() throws DataSourceException {
        try {
            return Subreddit.fromJson(dataSource.getDefaultSubreddits());
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse subreddits from JSON.", e);
        }
    }

    JsonDataSource getDataSource() {
        return dataSource;
    }

    void setDataSource(JsonDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
