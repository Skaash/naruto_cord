package de.skash.narutocordrewrite.core.model;

import de.skash.narutocordrewrite.core.api.model.Server;

public class ServerImpl implements Server {
    private final long id;
    private final String prefix;

    public ServerImpl(
            long id,
            String prefix
    ) {
        this.id = id;
        this.prefix = prefix;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(id);
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
