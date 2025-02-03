package org.example.cache.factory;

import org.example.cache.Cache;
import org.example.cache.policy.LRUEvictionPolicy;
import org.example.cache.storage.HashMapBasedStorage;

public class CacheFactory<K, V> {
    public Cache<K, V> newDefaultCache(int maxSize) {
        return new Cache(new LRUEvictionPolicy<K>(), new HashMapBasedStorage<K, V>(maxSize));
    }
}
