package com.am05.reddit.library.datasources;

import com.am05.reddit.library.things.Comment;
import com.am05.reddit.library.things.JsonToThingConverter;
import com.am05.reddit.library.things.Link;
import com.am05.reddit.library.things.Listing;
import com.am05.reddit.library.things.Subreddit;
import com.am05.reddit.library.things.factories.ThingFactoryException;

public class RedditDataSource {
    private JsonDataSource dataSource;

    public RedditDataSource() {
        dataSource = new LiveDataSource();
    }

    public Listing<Subreddit> getSubreddits(String sessionId) throws DataSourceException {
        try {
            return new JsonToThingConverter<Listing<Subreddit>>().convert(dataSource
                    .getSubreddits(sessionId));
        } catch (ThingFactoryException e) {
            throw new DataSourceException("Could not parse subreddits from JSON.", e);
        }
    }

    /**
     * @param subreddit
     *            The unique slug that identifies the subreddit
     * @return a list of links for the subreddit.
     * @throws DataSourceException
     */
    public Listing<Link> getLinksForSubreddit(String subreddit) throws DataSourceException {
        try {
            return new JsonToThingConverter<Listing<Link>>()
                    .convert(dataSource.getLinks(subreddit));
        } catch (ThingFactoryException e) {
            throw new DataSourceException("Could not parse links for subreddit: " + subreddit, e);
        }
    }

    public Listing<Comment> getCommentsForLink(Link link) throws DataSourceException {
        try {
            return new JsonToThingConverter<Listing<Comment>>().convert(dataSource.getComments(link
                    .getPermalink()));
        } catch (ThingFactoryException e) {
            throw new DataSourceException("Could not parse comments for link: " + link, e);
        }
    }

    public Subreddit getSubreddit(String subreddit) throws DataSourceException {
        try {
            return new JsonToThingConverter<Subreddit>()
                    .convert(dataSource.getSubreddit(subreddit));
        } catch (ThingFactoryException e) {
            throw new DataSourceException("Could not parse subreddits from JSON.", e);
        }
    }

    public Listing<Subreddit> getDefaultSubreddits() throws DataSourceException {
        try {
            return new JsonToThingConverter<Listing<Subreddit>>().convert(dataSource
                    .getDefaultSubreddits());
        } catch (ThingFactoryException e) {
            throw new DataSourceException("Could not parse subreddits from JSON.", e);
        }
    }

    public Listing<Link> getLinksForFrontPage() throws DataSourceException {
        try {
            return new JsonToThingConverter<Listing<Link>>().convert(dataSource
                    .getLinksForFrontPage());
        } catch (ThingFactoryException e) {
            throw new DataSourceException("Could not parse links for front page.", e);
        }
    }

    JsonDataSource getDataSource() {
        return dataSource;
    }

    void setDataSource(JsonDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
