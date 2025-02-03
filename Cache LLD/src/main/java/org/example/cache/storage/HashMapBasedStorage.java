package org.example.cache.storage;

import org.example.cache.exception.CacheFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K, V> implements Storage<K, V> {
    private final Map<K, V> storage;
    private final int maxSize;

    public HashMapBasedStorage(int maxSize) {
        this.storage = new HashMap<>();
        this.maxSize = maxSize;
    }

    @Override
    public void put(K key, V value) throws CacheFullException {
        if (this.storage.size() == maxSize) {
            throw new CacheFullException("Cache is Full");
        }

        this.storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return storage.get(key);
    }

    @Override
    public void remove(K key) {
        storage.remove(key);
    }
}
