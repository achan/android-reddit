package com.pocketreddit.library.things;

import java.net.URL;

import org.json.JSONObject;

import com.pocketreddit.library.things.Kind;
import com.pocketreddit.library.things.UserSubmittedContent;
import com.pocketreddit.library.JsonParsingException;

public class Link extends UserSubmittedContent {
    private static final long serialVersionUID = 1L;

    private boolean clicked;
    private String domain;
    private boolean hidden;
    private boolean selfPost;
    private Object media;
    private Object mediaEmbed;
    private int numComments;
    private boolean over18;
    private String permalink;
    private boolean saved;
    private int score;
    private URL thumbnail;
    private String title;
    private String url;
    private String modHash;

    public Link() {
    }

    public Link(JSONObject json) throws JsonParsingException {

    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isSelfPost() {
        return selfPost;
    }

    public void setSelfPost(boolean selfPost) {
        this.selfPost = selfPost;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Object getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(Object mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Link [clicked=" + clicked + ", domain=" + domain + ", hidden=" + hidden
                + ", selfPost=" + selfPost + ", media=" + media + ", mediaEmbed=" + mediaEmbed
                + ", numComments=" + numComments + ", over18=" + over18 + ", permalink="
                + permalink + ", saved=" + saved + ", score=" + score + ", thumbnail=" + thumbnail
                + ", title=" + title + ", url=" + url + ", modHash=" + modHash + "]";
    }

    public String getModHash() {
        return modHash;
    }

    public void setModHash(String modHash) {
        this.modHash = modHash;
    }

    @Override
    public Kind getKind() {
        return Kind.THREAD;
    }
}
