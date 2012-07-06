package com.am05.reddit.library.datasources;

import java.util.List;

import org.json.JSONException;

import com.am05.reddit.library.Comment;
import com.am05.reddit.library.JsonParsingException;
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

    /**
     * @param subreddit The unique slug that identifies the subreddit
     * @return a list of links for the subreddit.
     * @throws DataSourceException
     */
    public List<Link> getLinksForSubreddit(String subreddit) throws DataSourceException {
        try {
            return Link.fromJson(dataSource.getLinks(subreddit));
        } catch (JsonParsingException e) {
            throw new DataSourceException("Could not parse links for subreddit: " + subreddit, e);
        }
    }

    public List<Comment> getCommentsForLink(Link link) throws DataSourceException {
        try {
            return Comment.fromJson(dataSource.getComments(link.getPermalink()));
        } catch (JsonParsingException e) {
            throw new DataSourceException("Could not parse comments for link: " + link, e);
        }
    }

    public Subreddit getSubreddit(String subreddit) throws DataSourceException {
        try {
            return new Subreddit(dataSource.getSubreddit(subreddit));
        } catch (JSONException e) {
            throw new DataSourceException("Could not parse subreddits from JSON.", e);
        }
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
