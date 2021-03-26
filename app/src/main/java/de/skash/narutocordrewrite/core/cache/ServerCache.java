package de.skash.narutocordrewrite.core.cache;

import de.skash.narutocordrewrite.core.api.model.Server;

public class ServerCache extends ACache<Long, Server> {
    @Override
    public void cacheElement(Server element) {
        cache.put(element.getId(), element);
    }
}
