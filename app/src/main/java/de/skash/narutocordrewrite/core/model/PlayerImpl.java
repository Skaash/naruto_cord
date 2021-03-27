package de.skash.narutocordrewrite.core.model;

import de.skash.narutocordrewrite.core.api.model.Ninja;
import de.skash.narutocordrewrite.core.api.model.Pack;
import de.skash.narutocordrewrite.core.api.model.Player;

import java.util.List;

public class PlayerImpl implements Player {
    private final long id;
    private final List<Ninja> ninjas;
    private final List<Pack> packs;

    public PlayerImpl(
            long id,
            List<Ninja> ninjas,
            List<Pack> packs
    ) {
        this.id = id;
        this.ninjas = ninjas;
        this.packs = packs;
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
    public List<Ninja> getNinjas() {
        return ninjas;
    }

    @Override
    public List<Pack> getPacks() {
        return packs;
    }
}
