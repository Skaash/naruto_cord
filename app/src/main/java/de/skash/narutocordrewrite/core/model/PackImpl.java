package de.skash.narutocordrewrite.core.model;

import de.skash.narutocordrewrite.core.api.model.Ninja;
import de.skash.narutocordrewrite.core.api.model.Pack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PackImpl implements Pack {
    private final int id;
    private final String name;
    private final int price;
    private final List<Ninja> ninjas;
    private final Rarity rarity;

    public PackImpl(
            int id,
            String name,
            int price,
            List<Ninja> ninjas,
            Rarity rarity
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ninjas = ninjas;
        this.rarity = rarity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public List<Ninja> getNinjas() {
        return ninjas;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public List<Ninja> open() {
        var ninjasFromPack = new ArrayList<Ninja>();
        for (int i = 0; i < 3; i++) {
            var index = ThreadLocalRandom.current().nextInt(0, ninjas.size());
            ninjasFromPack.add(ninjas.get(index));
        }
        return ninjasFromPack;
    }
}
