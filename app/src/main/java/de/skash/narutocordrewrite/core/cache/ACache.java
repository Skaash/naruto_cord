package de.skash.narutocordrewrite.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public abstract class ACache<K, E> {
    protected final Map<K, E> cache = new ConcurrentHashMap<>();

    public E getElementByKey(K key) {
        return cache.get(key);
    }

    public abstract void cacheElement(E element);

    public void removeElementByKey(K key) {
        cache.remove(key);
    }

    public Set<Map.Entry<K, E>> getEntrySet() {
        return cache.entrySet();
    }

    public List<E> getElements(){
        return new ArrayList<>(cache.values());
    }
}
