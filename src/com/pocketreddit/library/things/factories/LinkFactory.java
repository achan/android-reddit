package com.pocketreddit.library.things.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.pocketreddit.library.things.Link;

public class LinkFactory implements ThingFactory {

    private JSONObject json;

    public LinkFactory(JSONObject json) {
        this.json = json;
    }

    public Link createThing() throws ThingFactoryException {
        Link link = new Link();
        try {
            JSONObject data = json.getJSONObject("data");
            link.setDomain(data.getString("domain"));
            link.setClicked(data.getBoolean("clicked"));
            link.setHidden(data.getBoolean("hidden"));
            link.setSelfPost(data.getBoolean("is_self"));
            link.setMedia(data.optJSONObject("media"));
            link.setNumComments(data.getInt("num_comments"));
            link.setOver18(data.optBoolean("over18", false));
            link.setPermalink(data.getString("permalink"));
            link.setSaved(data.getBoolean("saved"));
            link.setScore(data.getInt("score"));

            String thumbString = data.optString("thumbnail");
            
            //FIXME should not ignore self/default/nsfw thumbnails
            if (thumbString != null && !"".equals(thumbString) && !"self".equals(thumbString)
                    && !"default".equals(thumbString) && !"nsfw".equals(thumbString)) {
                link.setThumbnail(new URL(thumbString));
            }

            link.setTitle(data.getString("title"));
            link.setUrl(data.getString("url"));
        } catch (JSONException e) {
            throw new ThingFactoryException("Couldn't parse JSON object into link.", e);
        } catch (MalformedURLException e) {
            throw new ThingFactoryException("Couldn't parse URL for thumbnail in JSON value.", e);
        }

        return link;
    }
}
