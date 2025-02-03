package org.example.cache;

import org.example.cache.exception.CacheFullException;
import org.example.cache.policy.EvictionPolicy;
import org.example.cache.storage.Storage;

public class Cache<K, V> {
    private final EvictionPolicy<K> evictionPolicy;
    private final Storage<K, V> storage;

    public Cache(EvictionPolicy<K> evictionPolicy, Storage<K, V> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V value) throws IllegalAccessException {
        try {
            this.storage.put(key, value);
            evictionPolicy.accessed(key);
        } catch (CacheFullException e) {
            K evictedKey = evictionPolicy.evict();

            if (evictedKey == null) {
                throw new IllegalStateException("evicted key is null");
            }

            this.storage.remove(evictedKey);
            put(key, value);
        }
    }

    public V get(K key) {
        V value = this.storage.get(key);

        if (value != null) {
            this.evictionPolicy.accessed(key);
        }

        return value;
    }
}
