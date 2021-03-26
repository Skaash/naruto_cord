package de.skash.narutocordrewrite.core.cache;

import de.skash.narutocordrewrite.core.api.model.Player;

public class PlayerCache extends ACache<Long, Player> {
    @Override
    public void cacheElement(Player element) {
        cache.put(element.getId(), element);
    }
}
