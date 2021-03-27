package de.skash.narutocordrewrite.core.api.model;

import de.skash.narutocordrewrite.core.model.Element;
import de.skash.narutocordrewrite.core.model.Rarity;

public interface Jutsu {
    int getId();

    Element getElement();

    Rarity getRarity();

    int getDamage();
}
