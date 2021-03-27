package de.skash.narutocordrewrite.core.api.model;

import de.skash.narutocordrewrite.core.model.Element;
import de.skash.narutocordrewrite.core.model.Rarity;

import java.util.List;

public interface Ninja {
    int getId();

    int getDefence();

    Rarity getRarity();

    String getName();

    String getImageURL();

    Element getElement();

    List<Jutsu> getJutsus();
}
