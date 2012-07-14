package com.pocketreddit.library.things.utils;

import org.json.JSONException;
import org.json.JSONObject;

import com.pocketreddit.library.things.Kind;
import com.pocketreddit.library.things.More;
import com.pocketreddit.library.things.Thing;
import com.pocketreddit.library.things.factories.CommentFactory;
import com.pocketreddit.library.things.factories.LinkFactory;
import com.pocketreddit.library.things.factories.ListingFactory;
import com.pocketreddit.library.things.factories.SubredditFactory;
import com.pocketreddit.library.things.factories.ThingFactory;
import com.pocketreddit.library.things.factories.ThingFactoryException;

public class JsonToThingConverter<T extends Thing> {
    public JsonToThingConverter() {
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
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
            thingFactory = new ListingFactory(json);
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
        case MORE:
            return (T) new More();
        default:
            throw new UnsupportedOperationException("Kind: " + kind
                    + " conversion not yet supported.");
        }

        return (T) thingFactory.createThing();
    }
}
