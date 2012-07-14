package com.pocketreddit.library.things;

import com.pocketreddit.library.things.Message;
import com.pocketreddit.library.things.Subreddit;

public class Message {
	private String author;
	private String body;
	private String bodyHtml;
	private Message firstMessage;
	private String context;
	private String name;
	private boolean read;
	private String parentId;
	private String replies;
	private String subject;
	private Subreddit subreddit;
	private boolean comment;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public Message getFirstMessage() {
		return firstMessage;
	}

	public void setFirstMessage(Message firstMessage) {
		this.firstMessage = firstMessage;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getReplies() {
		return replies;
	}

	public void setReplies(String replies) {
		this.replies = replies;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Subreddit getSubreddit() {
		return subreddit;
	}

	public void setSubreddit(Subreddit subreddit) {
		this.subreddit = subreddit;
	}

	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}
}
