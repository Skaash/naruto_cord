package de.skash.narutocordrewrite.core.model;

import de.skash.narutocordrewrite.core.api.model.Jutsu;

public class JutsuImpl implements Jutsu {
    private final int id;
    private final Element element;
    private final int damage;
    private final Rarity rarity;

    public JutsuImpl(
            int id,
            Element element,
            int damage,
            Rarity rarity
    ) {
        this.id = id;
        this.element = element;
        this.damage = damage;
        this.rarity = rarity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Element getElement() {
        return element;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
