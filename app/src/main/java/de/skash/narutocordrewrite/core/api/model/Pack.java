package de.skash.narutocordrewrite.core.api.model;

import de.skash.narutocordrewrite.core.model.Rarity;

import java.util.List;

public interface Pack {
    int getId();

    String getName();

    int getPrice();

    List<Ninja> getNinjas();

    Rarity getRarity();

    List<Ninja> open();
}
