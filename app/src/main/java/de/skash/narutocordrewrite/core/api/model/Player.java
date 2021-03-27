package de.skash.narutocordrewrite.core.api.model;

import java.util.List;

public interface Player {
    long getId();

    String getIdAsString();

    List<Ninja> getNinjas();

    List<Pack> getPacks();


}
