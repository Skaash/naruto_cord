package de.skash.narutocordrewrite.core.model;

import de.skash.narutocordrewrite.core.api.model.Jutsu;
import de.skash.narutocordrewrite.core.api.model.Ninja;

import java.util.List;

public class NinjaImpl implements Ninja {
    private final int id;
    private final int defence;
    private final String name;
    private final String imageURL;
    private final Element element;
    private final List<Jutsu> jutsus;
    private final Rarity rarity;

    public NinjaImpl(
            int id,
            int defence,
            String name,
            String imageURL,
            Element element,
            List<Jutsu> jutsus,
            Rarity rarity
    ) {
        this.id = id;
        this.defence = defence;
        this.name = name;
        this.imageURL = imageURL;
        this.element = element;
        this.jutsus = jutsus;
        this.rarity = rarity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImageURL() {
        return imageURL;
    }

    @Override
    public Element getElement() {
        return element;
    }

    @Override
    public List<Jutsu> getJutsus() {
        return jutsus;
    }
}
