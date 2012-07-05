package com.am05.reddit.library;

import java.util.List;

import org.json.JSONObject;

public class Comment extends UserSubmittedContent {
	private String linkId;
	private String parentId;

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public static List<Comment> fromJson(JSONObject commentsForLink) {
		throw new UnsupportedOperationException();
	}
}
