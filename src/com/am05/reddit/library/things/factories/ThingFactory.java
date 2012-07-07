package com.am05.reddit.library.things.factories;

import com.am05.reddit.library.things.Thing;

public interface ThingFactory {
    public Thing createThing() throws ThingFactoryException;
}
