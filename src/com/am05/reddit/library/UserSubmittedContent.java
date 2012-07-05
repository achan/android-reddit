package com.am05.reddit.library;

public abstract class UserSubmittedContent implements Created, Votable {
	private int upvotes;
	private int downvotes;
	private Boolean liked;
	private long created;
	private long createdUtc;

	private String author;
	private String authorFlairCssClass;
	private String authorFlairText;
	private String body;
	private String bodyHtml;
	
	private Subreddit subreddit;

	public int getUpvotes() {
		return upvotes;
	}

	public int getDownvotes() {
		return downvotes;
	}

	public Boolean isLiked() {
		return liked;
	}

	public long getCreated() {
		// TODO Auto-generated method stub
		return created;
	}

	public long getCreatedUtc() {
		return createdUtc;
	}

	public Subreddit getSubreddit() {
		return subreddit;
	}

	public void setSubreddit(Subreddit subreddit) {
		this.subreddit = subreddit;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorFlairCssClass() {
		return authorFlairCssClass;
	}

	public void setAuthorFlairCssClass(String authorFlairCssClass) {
		this.authorFlairCssClass = authorFlairCssClass;
	}

	public String getAuthorFlairText() {
		return authorFlairText;
	}

	public void setAuthorFlairText(String authorFlairText) {
		this.authorFlairText = authorFlairText;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBodyHtml() {
		return bodyHtml;
	}

	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}
}
