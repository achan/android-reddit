package com.pocketreddit.library.things.factories;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.pocketreddit.library.things.Comment;
import com.pocketreddit.library.things.Listing;
import com.pocketreddit.library.things.Subreddit;
import com.pocketreddit.library.things.utils.JsonToThingConverter;

public class CommentFactory implements ThingFactory {
    private static final String TAG = CommentFactory.class.getName();
    private JSONObject json;

    public CommentFactory(JSONObject json) {
        this.json = json;
    }

    public Comment createThing() throws ThingFactoryException {
        Comment comment = new Comment();

        try {
            JSONObject data = json.getJSONObject("data");
            comment.setBody(data.optString("body"));
            comment.setBodyHtml(data.optString("body_html"));
            comment.setEdited(data.optBoolean("edited", false));
            Subreddit subreddit = new Subreddit();
            subreddit.setId(data.getString("subreddit_id"));
            subreddit.setDisplayName(data.getString("subreddit"));
            comment.setSubreddit(subreddit);
            comment.setAuthorFlairCssClass(data.getString("author_flair_css_class"));
            comment.setCreated(data.getDouble("created"));
            comment.setCreatedUtc(data.getDouble("created_utc"));
            comment.setDownvotes(data.getInt("downs"));
            comment.setAuthor(data.getString("author"));
            comment.setId(data.getString("id"));
            Log.v(TAG, "comment id: " + comment.getId());
            comment.setLinkId(data.getString("link_id"));
            comment.setParentId(data.getString("parent_id"));
            comment.setLiked(data.isNull("likes") ? null : data.getBoolean("likes"));
            comment.setAuthorFlairText(data.getString("author_flair_text"));

            if (!data.isNull("num_reports"))
                comment.setNumReports(data.getInt("num_reports"));

            comment.setUpvotes(data.getInt("ups"));
            comment.setName(data.getString("name"));
            JSONObject replies = data.optJSONObject("replies");
            if (replies != null) {
                comment.setReplies(new JsonToThingConverter<Listing<Comment>>().convert(replies));
            }
        } catch (JSONException e) {
            throw new ThingFactoryException("Could not convert reply JSON objects.", e);
        }

        return comment;
    }

}
