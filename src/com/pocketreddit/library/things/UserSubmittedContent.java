package com.pocketreddit.library.things;

import com.pocketreddit.library.things.Subreddit;
import com.pocketreddit.library.things.Thing;
import com.pocketreddit.library.Created;
import com.pocketreddit.library.Votable;

public abstract class UserSubmittedContent extends Thing implements Created, Votable {
    private static final long serialVersionUID = 1L;

    private String id;
	private int upvotes;
	private int downvotes;
	private Boolean liked;
	private double created;
	private double createdUtc;
	private String name;
	
	private String author;
	private String authorFlairCssClass;
	private String authorFlairText;
	private String body;
	private String bodyHtml;
	private boolean edited;
	private int numReports;
	
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

	public double getCreated() {
		// TODO Auto-generated method stub
		return created;
	}

	public double getCreatedUtc() {
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

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public void setCreatedUtc(double createdUtc) {
        this.createdUtc = createdUtc;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumReports() {
        return numReports;
    }

    public void setNumReports(int numReports) {
        this.numReports = numReports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
