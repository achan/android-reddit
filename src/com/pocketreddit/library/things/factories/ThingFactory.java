package com.pocketreddit.library.things.factories;

import com.pocketreddit.library.things.Thing;

public interface ThingFactory {
    public Thing createThing() throws ThingFactoryException;
}
