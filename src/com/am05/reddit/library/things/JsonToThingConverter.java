package com.am05.reddit.library.things;

import org.json.JSONException;
import org.json.JSONObject;

import com.am05.reddit.library.things.factories.CommentFactory;
import com.am05.reddit.library.things.factories.LinkFactory;
import com.am05.reddit.library.things.factories.ListingFactory;
import com.am05.reddit.library.things.factories.SubredditFactory;
import com.am05.reddit.library.things.factories.ThingFactory;
import com.am05.reddit.library.things.factories.ThingFactoryException;

public class JsonToThingConverter<T extends Thing> {
    public JsonToThingConverter() {
    }

    @SuppressWarnings("unchecked")
    public T convert(JSONObject json) throws ThingFactoryException {
        Kind kind;
        try {
            kind = Kind.toKind(json.getString("kind"));
        } catch (JSONException e) {
            throw new ThingFactoryException(
                    "An error occurred trying to parse the kind of thing in provided json", e);
        }

        ThingFactory thingFactory = null;

        switch (kind) {
        case SUBREDDIT:
            thingFactory = new SubredditFactory(json);
            break;
        case LISTING:
            thingFactory = new ListingFactory<T>(json);
            break;
        case THREAD:
            try {
                thingFactory = json.getJSONObject("data").isNull("domain") ? new CommentFactory(
                        json) : new LinkFactory(json);
            } catch (JSONException e) {
                throw new ThingFactoryException("Could not parse data for Thread thing.", e);
            }
            break;
        case COMMENT:
            thingFactory = new CommentFactory(json);
            break;
        default:
            throw new UnsupportedOperationException("Kind: " + kind
                    + " conversion not yet supported.");
        }

        return (T) thingFactory.createThing();
    }
}
