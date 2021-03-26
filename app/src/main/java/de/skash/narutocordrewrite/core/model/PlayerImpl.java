package de.skash.narutocordrewrite.core.model;

import de.skash.narutocordrewrite.core.api.model.Player;

public class PlayerImpl implements Player {
    private final long id;

    public PlayerImpl(
            long id
    ) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(id);
    }
}
