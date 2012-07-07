package com.am05.reddit.library;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Comment extends UserSubmittedContent {
    private static final String TAG = Comment.class.getName();
    private String linkId;
    private String parentId;
    private List<Comment> replies;

    public Comment() {

    }

    public Comment(JSONObject json) throws JsonParsingException {
        try {
            JSONObject data = json.getJSONObject("data");
            setBody(data.optString("body"));
            setBodyHtml(data.optString("body_html"));
            setEdited(data.optBoolean("edited", false));
            Subreddit subreddit = new Subreddit();
            subreddit.setId(data.getString("subreddit_id"));
            subreddit.setDisplayName(data.getString("subreddit"));
            setSubreddit(subreddit);
            setAuthorFlairCssClass(data.getString("author_flair_css_class"));
            setCreated(data.getDouble("created"));
            setCreatedUtc(data.getDouble("created_utc"));
            setDownvotes(data.getInt("downs"));
            setAuthor(data.getString("author"));
            setLinkId(data.getString("link_id"));
            setParentId(data.getString("parent_id"));
            setLiked(data.isNull("likes") ? null : data.getBoolean("likes"));
            setAuthorFlairText(data.getString("author_flair_text"));
            setId(data.getString("id"));

            if (!data.isNull("num_reports"))
                setNumReports(data.getInt("num_reports"));

            setUpvotes(data.getInt("ups"));
            setName(data.getString("name"));
            JSONObject replies = data.optJSONObject("replies");
            if (replies != null) {
                JSONArray repliesJson = replies.getJSONObject("data").getJSONArray("children");
                this.replies = new ArrayList<Comment>();
                for (int i = 0; i < repliesJson.length(); i++) {
                    Log.v(TAG, "creating reply comments");
                    Comment reply = new Comment(repliesJson.getJSONObject(i));
                    this.replies.add(reply);
                }
            }
        } catch (JSONException e) {
            throw new JsonParsingException(e);
        }
    }

    public String getLinkId() {
        return linkId;
    }

    @Override
    public String toString() {
        return "Comment [getUpvotes()=" + getUpvotes() + "\n getDownvotes()=" + getDownvotes()
                + "\n getAuthor()=" + getAuthor() + "\n getBody()=" + getBody() + "\n getName()="
                + getName() + "\nreplies=" + replies + "]";
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

    public static List<Comment> fromJson(JSONArray jsonComments) throws JsonParsingException {
        List<Comment> comments = new ArrayList<Comment>();
        for (int i = 1; i < jsonComments.length(); i++) {
            try {
                JSONArray jsonComments2 = jsonComments.getJSONObject(i).getJSONObject("data")
                        .getJSONArray("children");
                for (int j = 0; j < jsonComments2.length(); j++) {
                    comments.add(new Comment(jsonComments2.getJSONObject(j)));
                }
            } catch (JSONException e) {
                throw new JsonParsingException(e);
            }
        }

        return comments;
    }
}
