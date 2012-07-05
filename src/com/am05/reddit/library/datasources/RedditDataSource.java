package com.am05.reddit.library.datasources;

import java.util.List;

import com.am05.reddit.library.Account;
import com.am05.reddit.library.Comment;
import com.am05.reddit.library.Link;
import com.am05.reddit.library.Subreddit;

public class RedditDataSource {
	public static enum Environment {
		PRODUCTION, TEST
	}

	private JsonDataSource ds;

	public RedditDataSource(Environment env) {
		this.ds = env == Environment.PRODUCTION ? new LiveDataSource()
				: new MockDataSource();
	}

	public List<Subreddit> getSubredditsForAccount(Account account) {
		return Subreddit.fromJson(ds.getSubredditsForAccount(account.toJson()));
	}

	public List<Link> getLinksForSubreddit(Subreddit subreddit) {
		return Link.fromJson(ds.getLinksForSubreddit(subreddit.toJson()));
	}

	public List<Comment> getCommentsForLink(Link link) {
		return Comment.fromJson(ds.getCommentsForLink(link.toJson()));
	}

	public Subreddit getSubreddit(String subreddit) {
		return new Subreddit(ds.getSubreddit(subreddit));
	}

	public List<Subreddit> getDefaultSubreddits() {
		return Subreddit.fromJson(ds.getDefaultSubreddits());
	}
}
