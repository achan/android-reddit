package com.pocketreddit.library.things;

import com.pocketreddit.library.things.Comment;
import com.pocketreddit.library.things.Kind;
import com.pocketreddit.library.things.Listing;
import com.pocketreddit.library.things.UserSubmittedContent;

public class Comment extends UserSubmittedContent {
    private static final long serialVersionUID = 1L;

    private String linkId;
    private String parentId;
    private Listing<Comment> replies;

    public Comment() {
    }

    public String getLinkId() {
        return linkId;
    }

    @Override
    public String toString() {
        return "Comment [getUpvotes()=" + getUpvotes() + "\n getDownvotes()=" + getDownvotes()
                + "\n getAuthor()=" + getAuthor() + "\n getBody()=" + getBody() + "\n getName()="
                + getName() + "\nreplies=" + getReplies() + "]";
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

    @Override
    public Kind getKind() {
        return Kind.THREAD;
    }

    public Listing<Comment> getReplies() {
        return replies;
    }

    public void setReplies(Listing<Comment> replies) {
        this.replies = replies;
    }
}
