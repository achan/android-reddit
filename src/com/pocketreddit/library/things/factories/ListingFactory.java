package com.pocketreddit.library.things.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pocketreddit.library.things.Listing;
import com.pocketreddit.library.things.Thing;
import com.pocketreddit.library.things.utils.JsonToThingConverter;

public class ListingFactory<T extends Thing> implements ThingFactory {
    private JSONObject json;

    public ListingFactory(JSONObject json) {
        this.json = json;
    }

    public Listing<T> createThing() throws ThingFactoryException {
        Listing<T> listing = new Listing<T>();
        List<T> children = new ArrayList<T>();

        try {
            JSONObject data = json.getJSONObject("data");
            JSONArray jsonChildren = data.getJSONArray("children");
            for (int i = 0; i < jsonChildren.length(); i++) {
                JsonToThingConverter<T> converter = new JsonToThingConverter<T>();
                T thing = converter.convert(jsonChildren.getJSONObject(i));
                children.add(thing);
            }

            listing.setChildren(children);
            listing.setAfter(data.getString("after"));
            listing.setBefore(data.getString("before"));
        } catch (JSONException e) {
            throw new ThingFactoryException("Failed parsing JSON object into Thing.", e);
        }

        return listing;
    }
}
