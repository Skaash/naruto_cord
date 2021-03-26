package de.skash.narutocordrewrite.core.cache;

import de.skash.narutocordrewrite.core.command.Command;

public class CommandCache extends ACache<String, Command> {
    @Override
    public void cacheElement(Command element) {
        cache.put(element.getKeyword(), element);
    }
}
